package bridge;

import java.util.List;

public class Application {

    private static int size;

    private static String move;

    private static String retry;

    private static Error error;

    private static List<String> bridgeShape;

    private static List<String> topBridge;

    private static List<String> bottomBridge;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        prepareExceptionBeforeBridgeGame();
    }

    public static void prepareExceptionBeforeBridgeGame() {
        try {
            startBridgeGame();
        } catch (IllegalStateException e) {
            System.out.println(error.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(error.getMessage());
        }
    }

    public static void startBridgeGame() {
        setBridgeGame();
        playBridgeGame();
    }

    public static void setBridgeGame() {
        InputView inputView = new InputView();
        size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeShape = bridgeMaker.makeBridge(size);
    }

    public static void playBridgeGame() {

    }

    public static void setError(Error errorMessage) {
        error = errorMessage;
    }
}
