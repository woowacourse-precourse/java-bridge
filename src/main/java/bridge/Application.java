package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.startMsg();

        int bridgeSize = inputView.readBridgeSize();
    }
}
