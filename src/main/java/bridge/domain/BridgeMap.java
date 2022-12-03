package bridge.domain;

import bridge.message.Message;

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
            downRecord.add(Message.BLANK.getMessage());
        }
    }

    public static void addRecordMovingDown(boolean isMovingUp, boolean isBridgeUp) {
        if (!isMovingUp) {
            isMovingDownBridgeUp(isBridgeUp);
            isMovingDownBridgeDown(!isBridgeUp);
            upRecord.add(Message.BLANK.getMessage());
        }
    }

    public static void isMovingUpBridgeUp(boolean isBridgeUp) {
        if (isBridgeUp) {
            upRecord.add(Message.CORRECT.getMessage());
        }
    }

    public static void isMovingUpBridgeDown(boolean isBridgeDown) {
        if (isBridgeDown) {
            upRecord.add(Message.WRONG.getMessage());
        }
    }

    public static void isMovingDownBridgeUp(boolean isBridgeUp) {
        if (isBridgeUp) {
            downRecord.add(Message.WRONG.getMessage());
        }
    }

    public static void isMovingDownBridgeDown(boolean isBridgeDown) {
        if (isBridgeDown) {
            downRecord.add(Message.CORRECT.getMessage());
        }
    }

    public static List<String> getUpRecord() {
        return upRecord;
    }

    public static List<String> getDownRecord() {
        return downRecord;
    }

    public static int getMovingCount() {
        return upRecord.size();
    }
}
