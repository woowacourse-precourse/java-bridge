package bridge;

import java.util.List;

public class Application {
    private static InputView userInput;
    private static OutputView stdout;
    private static int size;
    private static String moving;
    private static BridgeGame bridgeGame;

    private static void init() {
        userInput = new InputView();
        stdout = new OutputView();
        size = initBridgeSize();
        bridgeGame = new BridgeGame(initBridge());
    }

    private static int readValidBridgeSize() {
        try {
            return userInput.readBridgeSize();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.printException(e);
            return ExceptionHandler.ERROR;
        }
    }

    private static int initBridgeSize() {
        int size = readValidBridgeSize();
        while (size == ExceptionHandler.ERROR) {
            size = readValidBridgeSize();
        }
        return size;
    }

    private static Bridge initBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(bridge, size);
    }

    private static String readValidMoving() {
        try {
            return userInput.readMoving();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.printException(e);
            return null;
        }
    }

    private static String setNextMoving() {
        String moving = readValidMoving();
        while (moving == null) {
            moving = readValidMoving();
        }
        return moving;
    }

    private static int runBridgeGame() {
        int state;
        do {
            moving = setNextMoving();
            bridgeGame.move(moving);
        } while((state = bridgeGame.isEnded()) == Utils.CONTINUE);
        return state;
    }

    public static void main(String[] args) {
        init();
        runBridgeGame();
    }
}
