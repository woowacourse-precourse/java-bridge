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
        int bridgeSize = InputView.readBridgeSize().getSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeGame = new BridgeGame(bridge);
        startMove();
        OutputView.printResult(bridgeGame.getMap(), bridgeGame.isSuccess(), bridgeGame.getTryCount());
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
