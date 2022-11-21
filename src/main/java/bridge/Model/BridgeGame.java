package bridge.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String NOTHING = " ";
    private static final String RIGHT_POSITION = "O";
    private static int bridgeSize;
    private static List<String> bridgeAnswer;
    private static int gameCount = 0;

    private static List<List<String>> currentBridge = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));

    public static void setBridgeSize(int bridgeSize) {
        BridgeGame.bridgeSize = bridgeSize;
    }

    public static int getBridgeSize() {
        return bridgeSize;
    }

    public static int getGameCount() {
        return gameCount;
    }

    public static void increaseGameCount() {
        gameCount++;
    }

    public static void setBridgeAnswer(List<String> bridgeAnswer) {
        BridgeGame.bridgeAnswer = bridgeAnswer;
    }

    public static List<List<String>> getCurrentBridge() {
        return Collections.unmodifiableList(currentBridge);
    }

    public static void move(String nextPosition, int currentBridgeSize) {
        String answerPosition = bridgeAnswer.get(currentBridgeSize);
        boolean isEqual = nextPosition.equals(answerPosition);
        if (isEqual) {
            rightMove(nextPosition);
        }
        if (!isEqual) {

        }
    }

    public static void rightMove(String nextPosition) {
        if (nextPosition.equals(UP)) {
            currentBridge.get(0).add(RIGHT_POSITION);
            currentBridge.get(1).add(NOTHING);
        }
        if (nextPosition.equals(DOWN)) {
            currentBridge.get(0).add(NOTHING);
            currentBridge.get(1).add(RIGHT_POSITION);
        }
    }

    public void retry() {
    }
}