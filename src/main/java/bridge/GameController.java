package bridge;

import bridge.domain.Bridge;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameController(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void startGame() {
        Bridge bridge = makeBridgeInputSize();
        bridgeGame = new BridgeGame(bridge);
        startMove();
        OutputView.printResult(bridgeGame.getMap(), bridgeGame.isSuccess(), bridgeGame.getTryCount());
    }

    private Bridge makeBridgeInputSize() {
        int size = InputView.readBridgeSize().getSize();
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private void startMove() {
        boolean isContinue = true;
        do {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getMap());
            if (!bridgeGame.canMove()) {
                isContinue = bridgeGame.retry(InputView.readGameCommand());
            }
        } while (!bridgeGame.isFinish() && isContinue);
    }
}
