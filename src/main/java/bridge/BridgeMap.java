package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private static final List<String> upRecord = new ArrayList<>();
    private static final List<String> downRecord = new ArrayList<>();

    public static void reset() {
        upRecord.clear();
        downRecord.clear();
    }

    public static void addRecordMovingUp(boolean isMovingUp, boolean isBridgeUp) {
        if (isMovingUp) {
            isMovingUpBridgeUp(isBridgeUp);
            isMovingUpBridgeDown(!isBridgeUp);
            downRecord.add(" ");
        }
    }

    public static void addRecordMovingDown(boolean isMovingUp, boolean isBridgeUp) {
        if (!isMovingUp) {
            isMovingDownBridgeUp(isBridgeUp);
            isMovingDownBridgeDown(!isBridgeUp);
            upRecord.add(" ");
        }
    }

    public static void isMovingUpBridgeUp(boolean isBridgeUp) {
        if (isBridgeUp) {
            upRecord.add("O");
        }
    }

    public static void isMovingUpBridgeDown(boolean isBridgeDown) {
        if (isBridgeDown) {
            upRecord.add("X");
        }
    }

    public static void isMovingDownBridgeUp(boolean isBridgeUp) {
        if (isBridgeUp) {
            downRecord.add("X");
        }
    }

    public static void isMovingDownBridgeDown(boolean isBridgeDown) {
        if (isBridgeDown) {
            downRecord.add("O");
        }
    }

    public static List<String> getUpRecord() {
        return upRecord;
    }

    public static List<String> getDownRecord() {
        return downRecord;
    }
}
