package bridge.domain;

import bridge.enums.InputKey;

import java.util.StringJoiner;

public class Result {
    private static final char O_FLAG = 'O';
    private static final char X_FLAG = 'X';
    public static final int BLANK = 32;

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

    public int handleUpBridge(String input, int position) {
        if (input.equals(InputKey.U.getValue())) {
            upBridgeStatus[position] = O_FLAG;
            return position;
        }
        upBridgeStatus[position] = X_FLAG;
        return -1;
    }

    public int handleDownBridge(String input, int position) {
        if (input.equals(InputKey.D.getValue())) {
            downBridgeStatus[position] = O_FLAG;
            return position;
        }
        downBridgeStatus[position] = X_FLAG;
        return -1;
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
        StringBuilder result = new StringBuilder("최종 게임 결과\n");
        result.append(this + "\n");
        result.append("게임 성공 여부: ");
        if (upBridgeStatus[upBridgeStatus.length - 1] == O_FLAG ||
                downBridgeStatus[downBridgeStatus.length - 1] == O_FLAG) {
            result.append("성공\n");
            result.append("총 시도한 횟수: " + tryCount);
            return result.toString();
        }
        result.append("실패\n");
        result.append("총 시도한 횟수: " + tryCount);
        return result.toString();
    }
}
