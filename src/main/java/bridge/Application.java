package bridge;

import view.InputView;
import view.OutputView;

public class Application {
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        outputView.printStart();
        play(inputView.readBridgeSize());
    }

    public static void play(int size) {
        Bridge bridge = bridgeGame.setBridge(size);
        for (int i = 0; i < size; i++) {
            if (bridgeGame.isMoving(bridge, move(bridge))) {
                continue;
            }
            if (!isRestart()) {
                break;
            }
        }
    }

    private static String move(Bridge bridge) {
        String moving = inputView.readMoving();
        outputView.printMap(bridgeGame.move(bridge, moving));
        return moving;
    }

    private static boolean isRestart() {
        if (!inputView.readGameCommand().isRestart())
            return false;
        bridgeGame.retry();
        return true;
    }
}
