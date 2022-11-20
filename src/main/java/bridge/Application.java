package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int bridgeSize = inputView.readBridgeSize();
        System.out.println(bridgeSize);
    }
}
