package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {
    private final BridgeGame bridgeGame;
    private final Bridge bridge;

    public GameManager(BridgeMaker bridgeMaker) {
        OutputView.printGameStartMessage();
        bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        boolean status;
        do {
            status = moveForward();
        } while (status && isRetry());

        OutputView.printResult(bridgeGame);
    }

    private boolean moveForward() {
        while (bridgeGame.canMove()) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        return bridgeGame.isFail();
    }

    private boolean isRetry() {
        if (Key.matchEnd(InputView.readGameCommand())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}
