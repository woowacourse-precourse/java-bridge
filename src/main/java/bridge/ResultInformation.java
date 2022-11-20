package bridge;

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

}
