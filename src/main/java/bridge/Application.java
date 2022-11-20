package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int size;

    private static Error error;

    private static int number = 0;

    private static boolean passFail = true;

    private static InputView inputView = new InputView();

    private static OutputView outputView = new OutputView();

    private  static BridgeGame bridgeGame = new BridgeGame();

    private static List<String> bridgeShape = new ArrayList<>();

    private static List<String> topBridge = new ArrayList<>();

    private static List<String> bottomBridge = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        prepareExceptionBeforeBridgeGame();
    }

    public static void prepareExceptionBeforeBridgeGame() {
        try {
            startBridgeGame();
            endBridgeGame();
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
        size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeShape = bridgeMaker.makeBridge(size);
    }

    public static void playBridgeGame() {

    }

    public static void endBridgeGame() {
        outputView.printResult(topBridge, bottomBridge);
        outputView.printSFAndNumber(passFail, number);
    }

    public static void setError(Error errorMessage) {
        error = errorMessage;
    }
}
