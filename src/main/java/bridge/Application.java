package bridge;

public class Application {
    private static InputView inputView = InputView.getInstance();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        constructBridge();
    }

    private static void constructBridge() {
        int bridgeSize = inputView.readBridgeSize();
    }
}
