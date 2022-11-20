package bridge;

public class Application {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static int position = 0;
    private static boolean stopFlag = false;
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        try {
            output.startGame();
            int bridgeSize = input.readBridgeSize();
            bridgeGame = new BridgeGame(bridgeSize);
            runGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runGame() {
        while (!stopFlag) {
            boolean available = moveAndPrint(position);
            if (available) {
                executeInAvailable();
            }
            if (!available) {
                executeInUnavailable();
            }
        }
    }

    private static boolean moveAndPrint(int position) {
        String moving = input.readMoving();
        boolean available = bridgeGame.move(moving, position);
        output.printMap(position, available, bridgeGame.bridge);
        return available;
    }

    private static void executeInAvailable() {
        position += 1;
        int bridgeSize = bridgeGame.getSize();
        if (position == bridgeSize) {
            stopGame(bridgeSize - 1, true);
        }
    }

    private static void executeInUnavailable() {
        String retry = input.readGameCommand();
        if (!bridgeGame.retry(retry)) {
            stopGame(position, false);
        }
    }

    private static void stopGame(int position, boolean available) {
        output.printResult(position, available, bridgeGame);
        stopFlag = true;
    }
}
