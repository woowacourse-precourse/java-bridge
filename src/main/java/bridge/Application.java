package bridge;

public class Application {

    private static InputView input = new InputView();
    private static OutputView output = new OutputView();
    private static BridgeGame game;

    public static void main(String[] args) {
        output.printGameStart();
        game = createGame();
    }

    private static BridgeGame createGame() {
        output.printRequestInputBridgeSize();
        while (true) {
            try {
                return new BridgeGame(new BridgeRandomNumberGenerator(), input.readBridgeSize());
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    private static int getMove() {
        output.printRequestInputMove();
        while (true) {
            try {
                return input.readMoving();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }
}
