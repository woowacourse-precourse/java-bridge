package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printGameStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        System.out.println("bridgeSize = " + bridgeSize);
    }
}
