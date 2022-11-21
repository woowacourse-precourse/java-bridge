package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int bridgeSize;
    private int attempts;
    private static List<String> movingRecord;

    public User() {
        bridgeSize = 0;
        attempts = 1;
        movingRecord = new ArrayList<String>();
    }

    public static void setBridgeSize(String userInput) {
        bridgeSize = Integer.parseInt(userInput);
    }

    public void resetUserMoving() {
        movingRecord = new ArrayList<String>();
    }

    public static void recordUserMoving(String userInput) {
        movingRecord.add(userInput);
    }

    public void plusAttempts() {
        attempts++;
    }

    public static int getBridgeSize() {
        return bridgeSize;
    }

    public static List<String> getUserMovingRecord() {
        return movingRecord;
    }

    public int getAttempts() {
        return attempts;
    }
}
