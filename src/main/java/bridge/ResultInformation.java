package bridge;

import java.util.StringJoiner;

public class ResultInformation {
    private static final int BLANK = 32;
    private static final char O_SIGN = 'O';
    private final char[] upBridge;
    private final char[] downBridge;
    private final int bridgeSize;
    private int tryCount = 0;

    public ResultInformation(int size) {
        this.bridgeSize = size;
        this.upBridge = new char[size];
        this.downBridge = new char[size];
    }

    void updateUpBridge(Position position, char sign) {
        upBridge[position.getPosition()] = sign;
    }

    void updateDownBridge(Position position, char sign) {
        downBridge[position.getPosition()] = sign;
    }

    String makeMap(int tryCount) {
        StringJoiner upJoiner = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < tryCount; i++) {
            upJoiner.add(String.valueOf(upBridge[i]));
            downJoiner.add(String.valueOf(downBridge[i]));
        }
        return upJoiner + "\n" + downJoiner;
    }
    void clear() {
        for (int i = 0; i < bridgeSize; i++) {
            upBridge[i] = (char) BLANK;
            downBridge[i] = (char) BLANK;
        }
        tryCount++;
    }

    boolean isPossibility() {
        return upBridge[bridgeSize - 1] == O_SIGN || downBridge[bridgeSize - 1] == O_SIGN;
    }
}
