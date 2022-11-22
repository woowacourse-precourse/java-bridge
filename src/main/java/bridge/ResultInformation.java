package bridge;

import java.util.StringJoiner;

public class ResultInformation {
    private static final char O_SIGN = 'O';
    private final char[] upBridge;
    private final char[] downBridge;
    private final int bridgeSize;
    private int tryCount = 1;

    public ResultInformation(int size) {
        this.bridgeSize = size;
        this.upBridge = new char[size];
        this.downBridge = new char[size];
    }

    public void updateUpBridge(int position, char sign) {
        upBridge[position] = sign;
    }

    public void updateDownBridge(int position, char sign) {
        downBridge[position] = sign;
    }

    public String makeMap(int stage) {
        StringJoiner upJoiner = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < stage + 1; i++) {
            upJoiner.add(String.valueOf(upBridge[i]));
            downJoiner.add(String.valueOf(downBridge[i]));
        }
        return upJoiner + "\n" + downJoiner;
    }
    public void clear() {
        for (int i = 0; i < bridgeSize; i++) {
            upBridge[i] = '\u0000';
            downBridge[i] = '\u0000';
        }
        tryCount++;
    }

    public boolean isPossibility() {
        return upBridge[bridgeSize - 1] == O_SIGN || downBridge[bridgeSize - 1] == O_SIGN;
    }

    public int getTryCount() {
        return tryCount;
    }
}
