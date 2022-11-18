package bridge;

public class Application {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        try {
            output.startGame();
            int bridgeSize = input.readBridgeSize();
            bridgeGame = new BridgeGame(bridgeSize);
            int position = 0;
            while (true) {
                moveAndPrint(position);
                position += 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void moveAndPrint(int position) {
        String moving = input.readMoving();
    }
}
