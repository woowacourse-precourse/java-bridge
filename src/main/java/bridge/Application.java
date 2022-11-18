package bridge;

public class Application {
    InputView inputView = new InputView();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readBridgeSize();
        int bridgeSize = inputView.getBridgeSize();
        inputView.readMoving();
        String move = inputView.getReadMoving();
        inputView.readGameCommand();
        String retry = inputView.getReadGameCommand();



    }
}
