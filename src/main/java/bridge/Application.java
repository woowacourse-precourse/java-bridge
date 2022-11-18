package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            OutputView outputView = new OutputView();
            InputView inputView = new InputView();

            outputView.printGameStartMessage();
            int bridgeSize = inputView.readBridgeSize();
            System.out.println("bridgeSize = " + bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
