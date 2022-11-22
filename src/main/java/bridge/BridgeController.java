package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeShape;
import bridge.domain.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void gameStart() {
        outputView.printGameStart();
        BridgeGame bridgeGame = playGame(new BridgeGame(createBridge()));
        outputView.printResult(bridgeGame.result(), bridgeGame.tryCount());
    }

    private Bridge createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeShapeValues = bridgeMaker.makeBridge(bridgeSize);
        return Bridge.createByBridgeShapeValue(bridgeShapeValues);
    }

    private BridgeGame playGame(BridgeGame bridgeGame) {
        while (bridgeGame.isNotEnd()) {
            BridgeGameResult result = move(bridgeGame);
            if (result.isFail()) {
                return retryGame(bridgeGame);
            }
        }
        return bridgeGame;
    }

    private BridgeGame retryGame(BridgeGame bridgeGame) {
        if (GameCommand.of(inputView.readGameCommand()).isRetry()) {
            return playGame(bridgeGame.retry());
        }
        return bridgeGame;
    }

    private BridgeGameResult move(BridgeGame bridgeGame) {
        BridgeShape moveBridgeShape = BridgeShape.of(inputView.readMoving());
        bridgeGame.move(moveBridgeShape);
        BridgeGameResult result = bridgeGame.result();
        outputView.printMap(result);
        return result;
    }
}
