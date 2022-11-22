package bridge.contoller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private BridgeGame bridgeGame;


    public void start() {
        outputView.printGameStartMessage();
        bridgeGame = new BridgeGame(inputLength());
        crossBridge();
    }

    private List<String> inputLength() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void crossBridge() {
        while (!bridgeGame.isEnd()) {
            if (!tryMove()) {
                break;
            }
        }

        outputView.printResult(bridgeGame);
    }


    private boolean tryMove() {
        if (bridgeGame.move(inputView.readMoving())) {
            outputView.printMap(bridgeGame.getBridgeTokens());
            return true;
        }
        outputView.printMap(bridgeGame.getBridgeTokens());
        return bridgeGame.retry(inputView.readGameCommand());
    }

}