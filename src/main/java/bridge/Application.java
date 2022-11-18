package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printStart();
        outputView.printEnterBridgeSize();
        inputView.readBridgeSize();
    }
}
