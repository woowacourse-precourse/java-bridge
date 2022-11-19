package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();

        int bridgeSize = inputView.readBridgeSize();
        System.out.println(bridgeSize);
    }
}
