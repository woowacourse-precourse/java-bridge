package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            InputView input = new InputView();
            OutputView output = new OutputView();

            output.startGame();
            int bridgeSize = input.readBridgeSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
