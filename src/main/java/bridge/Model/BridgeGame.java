package bridge.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {


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

    public void move() {
    }

    public void retry() {
    }
}