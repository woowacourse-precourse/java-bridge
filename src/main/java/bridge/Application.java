package bridge;

import java.util.List;

public class Application {
    private static InputView stdin;
    private static OutputView stdout;
    private static int size;
    private static String moving;
    private static BridgeGame bridgeGame;
    private static int state;
    private static int count = 1;
    private static int limit = 0;

    private static void init() {
        stdin = new InputView();
        stdout = new OutputView();
        size = initBridgeSize();
        bridgeGame = new BridgeGame(initBridge());
    }

    private static int readValidBridgeSize() {
        try {
            return stdin.readBridgeSize();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.printException(e);
            return ExceptionHandler.ERROR;
        }
    }

    private static int initBridgeSize() throws IllegalStateException {
        limit = 0;
        int size = readValidBridgeSize();
        while (size == ExceptionHandler.ERROR && !ExceptionHandler.exeedLimit(limit)) {
            limit++;
            size = readValidBridgeSize();
        }
        if (ExceptionHandler.exeedLimit(limit)) {
            throw new IllegalStateException("[ERROR] 잘못된 입력이 너무 많아 비정상 종료되었습니다.");
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
            return stdin.readMoving();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.printException(e);
            return null;
        }
    }

    private static String setNextMoving() throws IllegalStateException {
        limit = 0;
        String moving = readValidMoving();
        while (moving == null && !ExceptionHandler.exeedLimit(limit)) {
            limit++;
            moving = readValidMoving();
        }
        if (ExceptionHandler.exeedLimit(limit)) {
            throw new IllegalStateException("[ERROR] 잘못된 입력이 너무 많아 비정상 종료되었습니다.");
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
            return stdin.readGameCommand().equals(Utils.RESTART);
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
