package bridge;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        ready();
        do {
            move();
        } while (!quit());
        finish();
    }

    private static void finish() {
        outputView.printResult(bridgeGame);
    }

    private static boolean quit() {
        if (bridgeGame.clear()) return true;
        if (bridgeGame.isDead()) {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) return true;
            if (gameCommand.equals("R")) bridgeGame.retry();
        }
        return false;
    }

    private static void move() {
        String direction = inputView.readMoving();
        bridgeGame.move(direction);
        outputView.printMap(bridgeGame);
    }

    public static void ready() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }
}
