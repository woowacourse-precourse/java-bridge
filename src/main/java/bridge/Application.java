package bridge;

import java.util.List;

public class Application {
    private static InputView userInput;
    private static OutputView stdout;
    private static int size;
    private static String moving;
    private static BridgeGame bridgeGame;
    private static int state;
    private static int count = 1;
    private static int limit = 0;

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

    private static int initBridgeSize() throws IllegalStateException {
        limit = 0;
        int size = readValidBridgeSize();
        while (size == ExceptionHandler.ERROR && limit <= Utils.LIMIT) {
            limit++;
            size = readValidBridgeSize();
        }
        if (limit > Utils.LIMIT) {
            throw new IllegalStateException("[ERROR] 잘못된 입력을 너무 많아 비정상 종료되었습니다.");
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

    private static String setNextMoving() throws IllegalStateException {
        limit = 0;
        String moving = readValidMoving();
        while (moving == null && limit <= Utils.LIMIT) {
            limit++;
            moving = readValidMoving();
        }
        if (limit > Utils.LIMIT) {
            throw new IllegalStateException("[ERROR] 잘못된 입력을 너무 많아 비정상 종료되었습니다.");
        }
        return moving;
    }

    private static int runBridgeGame() {
        do {
            moving = setNextMoving();
            bridgeGame.move(moving);
            stdout.printMap(bridgeGame.report());
        } while ((state = bridgeGame.isEnded()) == Utils.CONTINUE);
        return state;
    }

    private static boolean startBridgeGame() {
        if (runBridgeGame() == Utils.FAIL) {
            return userInput.readGameCommand().equals(Utils.RESTART);
        }
        return false;
    }

    private static void finishBridgeGame() {
        stdout.printResult(bridgeGame.report(), state, count);
    }

    private static void run() {
        init();
        while (startBridgeGame()) {
            bridgeGame.retry();
            count++;
        }
        finishBridgeGame();
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            ExceptionHandler.printException(e);
        }
    }
}
