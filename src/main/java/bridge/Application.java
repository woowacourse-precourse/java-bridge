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

    private static BridgeGame bridgeGame = new BridgeGame();

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
        outputView.printGameStart();
        setBridgeGame();
        do {
            number++;
            playBridgeGame();
            if (passFail) {
                break;
            }
        } while (replayBridgeGame());
    }

    public static void setBridgeGame() {
        outputView.printBridgeSizeInputBox();
        size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeShape = bridgeMaker.makeBridge(size);
    }

    public static void playBridgeGame() {
        while (true) {
            bridgeMovement();
            outputView.printMap(topBridge, bottomBridge);
            if (topBridge.size() == size || !passFail) {
                break;
            }
        }
    }

    public static void endBridgeGame() {
        outputView.printResult(topBridge, bottomBridge);
        outputView.printSFAndNumber(passFail, number);
    }

    public static boolean replayBridgeGame() {
        outputView.printGameCommand();
        if (!bridgeGame.retry(inputView.readGameCommand())) {
            return false;
        }
        topBridge.clear();
        bottomBridge.clear();
        passFail = true;
        return true;
    }

    public static void bridgeMovement() {
        outputView.printMovingInputBox();
        String move = inputView.readMoving();
        if (!bridgeGame.rightMove(move, bridgeShape.get(topBridge.size()))) {
            bridgeGame.failure(topBridge, bottomBridge, move);
            passFail = false;
            return;
        }
        bridgeGame.move(topBridge, bottomBridge, move);
    }

    public static void setError(Error errorMessage) {
        error = errorMessage;
    }
}
