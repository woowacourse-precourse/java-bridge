package bridge.domain;

import java.util.StringJoiner;

public class ResultInformation {
    public static final int BLANK = 32;
    private static final char O_FLAG = 'O';

    public final char[] upBridge;
    public final char[] downBridge;
    private final int bridgeLength;
    private int tryCount = 1;

    public ResultInformation(int size) {
        this.bridgeLength = size;
        this.upBridge = new char[size];
        this.downBridge = new char[size];
        for (int i = 0; i < size; i++) {
            upBridge[i] = BLANK;
            downBridge[i] = BLANK;
        }
    }

    public void updateUpBridge(Position position, char flag) {
        upBridge[position.getPosition()] = flag;
    }

    public void updateDownBridge(Position position, char flag) {
        downBridge[position.getPosition()] = flag;
    }

    public void clear() {
        for (int i = 0; i < bridgeLength; i++) {
            upBridge[i] = BLANK;
            downBridge[i] = BLANK;
        }
        tryCount++;
    }

    public boolean isWin() {
        return upBridge[bridgeLength - 1] == O_FLAG || downBridge[bridgeLength - 1] == O_FLAG;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String toString(int tryCount) {
        StringJoiner upJoiner = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < tryCount; i++) {
            upJoiner.add(String.valueOf(upBridge[i]));
            downJoiner.add(String.valueOf(downBridge[i]));
        }
        return upJoiner + "\n" + downJoiner;
    }
}
