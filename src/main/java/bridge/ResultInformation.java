package bridge;

import java.util.StringJoiner;

public class ResultInformation {
    private final char[] upBridge;
    private final char[] downBridge;
    private final int bridgeSize;

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

}
