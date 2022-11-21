package bridge;

import static bridge.io.InputView.*;
import static bridge.io.OutputView.*;

public class Application {

    private static BridgeGame bridgeGame;

    public static void main(final String[] args) {
        try {
            bridgeGame = createBridgeGame();
            setupGame();
            playGame();
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame() {
        while (true) {
            if (crossBridge()) {
                finishGame();
                return;
            }
            if (!checkRetry()) {
                finishGame();
                return;
            }
            bridgeGame.retry();
            UPPER_BRIDGE_RESULT = new StringBuilder();
            LOWER_BRIDGE_RESULT = new StringBuilder();
        }
    }

    private static BridgeGame createBridgeGame() {
        printStartMessage();
        final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeGame(bridgeMaker);
    }

    private static void setupGame() {
        printGetBridgeSize();
        UPPER_BRIDGE_RESULT = new StringBuilder();
        LOWER_BRIDGE_RESULT = new StringBuilder();
        final int bridgeSize = readBridgeSize();
        bridgeGame.setupGame(bridgeSize);
    }

    private static boolean crossBridge() {
        final int bridgeSize = bridgeGame.getBridgeSize();
        for (int i = 0; i < bridgeSize; i++) {
            printGetBridgeCourse();
            if (!move(readCourse())) {
                return false;
            }
        }
        bridgeGame.success();
        return true;
    }

    private static boolean move(final String course) {
        final boolean result = bridgeGame.move(course);
        printMap(course, result);
        return result;
    }

    private static boolean checkRetry() {
        printGetRestartCommand();
        final String command = readRestartCommand();
        return command.equals("R");
    }

    private static void finishGame() {
        String result = "실패";
        if (bridgeGame.isSucceed()) {
            result = "성공";
        }
        final int tries = bridgeGame.getTries();
        printResult(result, tries);
    }
}
