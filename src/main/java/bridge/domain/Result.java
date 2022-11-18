package bridge.domain;

import bridge.enums.InputKey;
import bridge.enums.ViewMessage;

import java.text.MessageFormat;
import java.util.StringJoiner;

public class Result {
    private static final char O_FLAG = 'O';
    private static final char X_FLAG = 'X';
    public static final int BLANK = 32;
    private static final String WIN = "성공";
    private static final String FAIL = "실패";

    private final char[] upBridgeStatus;
    private final char[] downBridgeStatus;
    private int tryCount = 1;

    public Result(int size) {
        this.upBridgeStatus = new char[size];
        this.downBridgeStatus = new char[size];
        for (int i = 0; i < size; i++) {
            upBridgeStatus[i] = BLANK;
            downBridgeStatus[i] = BLANK;
        }
    }

    public void handleUpBridge(String input, Position position) {
        if (InputKey.isUp(input)) {
            upBridgeStatus[position.getPosition()] = O_FLAG;
            return;
        }
        upBridgeStatus[position.getPosition()] = X_FLAG;
        position.fail();
    }

    public void handleDownBridge(String input, Position position) {
        if (InputKey.isDown(input)) {
            downBridgeStatus[position.getPosition()] = O_FLAG;
            return;
        }
        downBridgeStatus[position.getPosition()] = X_FLAG;
        position.fail();
    }

    public void clear() {
        for (int i = 0; i < upBridgeStatus.length; i++) {
            upBridgeStatus[i] = BLANK;
            downBridgeStatus[i] = BLANK;
        }
        tryCount++;
    }

    public String printStatus(int count) {
        StringJoiner upJoiner = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < count; i++) {
            upJoiner.add(String.valueOf(upBridgeStatus[i]));
            downJoiner.add(String.valueOf(downBridgeStatus[i]));
        }
        return upJoiner + "\n" + downJoiner;
    }

    @Override
    public String toString() {
        boolean flag = upBridgeStatus[upBridgeStatus.length - 1] == O_FLAG ||
                downBridgeStatus[downBridgeStatus.length - 1] == O_FLAG;
        if (flag) {
            return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_RESULT.getValue(), WIN, tryCount);
        }
        return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_RESULT.getValue(), FAIL, tryCount);
    }
}
