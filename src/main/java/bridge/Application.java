package bridge;

public class Application {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static BridgeGame bridgeGame;
    private static int trying = 1;

    public static void main(String[] args) {
        try {
            output.startGame();
            int bridgeSize = input.readBridgeSize();
            bridgeGame = new BridgeGame(bridgeSize);
            int position = 0;
            while (true) {
                boolean available = moveAndPrint(position);

                if (available) {
                    if (position == bridgeSize - 1) {
                        output.printResult(bridgeSize - 1, true, bridgeGame.bridge, trying);
                        break;
                    }
                    position += 1;
                    continue;
                }

                if (!available) {
                    String retry = input.readGameCommand();
                    if (retry.equals(Input.RETRY.toString())) {
                        trying += 1;
                        bridgeGame.retry();
                    }
                    if (retry.equals(Input.QUIT.toString())) {
                        output.printResult(position, false, bridgeGame.bridge, trying);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean moveAndPrint(int position) {
        String moving = input.readMoving();
        boolean available = bridgeGame.isAvailable(moving, position);
        output.printMap(position, available, bridgeGame.bridge);
        return available;
    }
}
