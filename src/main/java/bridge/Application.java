package bridge;

import view.InputView;
import view.OutputView;

public class Application {
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        outputView.printStart();
        Bridge bridge = bridgeGame.setBridge(inputView.readBridgeSize());
        play(bridge);
        outputView.printResult(bridgeGame, bridge);
    }

    public static void play(Bridge bridge) {
        while (!bridgeGame.isFinish(bridge)) {
            if (bridgeGame.isMoving(bridge, move(bridge))) {
                continue;
            }
            if (!isRestart()) {
                break;
            }
        }
    }

    private static Moving move(Bridge bridge) {
        Moving moving =  inputView.readMoving();
        bridgeGame.move(bridge, moving);
        outputView.printMap(bridgeGame.getMovedBridge());
        return moving;
    }

    private static boolean isRestart() {
        if (!inputView.readGameCommand().isRestart())
            return false;
        bridgeGame.retry();
        return true;
    }
}
