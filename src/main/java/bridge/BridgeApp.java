package bridge;

import bridge.domain.CommandType;
import bridge.domain.result.Result;
import bridge.view.ViewController;

public class BridgeApp {
    private final ViewController viewController;
    private final BridgeGame bridgeGame;

    public BridgeApp(ViewController viewController, BridgeGame bridgeGame) {
        this.viewController = viewController;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        while (true) {
            try {
                bridgeGame.createBridge(viewController.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        viewController.printResult(playAndGetResult());

    }

    private Result playAndGetResult() {
        while (true) {
            Result result = moveBridge();
            if (result.isSucceeded()) {
                continue;
            }
            if (result.isFinished() || checkQuit()) {
                return result;
            }
            bridgeGame.retry();
        }
    }

    private Result moveBridge() {
        Result result = bridgeGame.move(viewController.readMoving());
        viewController.printMap(result.toMap());
        return result;
    }

    private boolean checkQuit() {
        CommandType commandType = viewController.readGameCommand();
        return commandType.isQuit();
    }

}
