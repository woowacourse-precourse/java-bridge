package bridge.domain;

public class CompareResult {

    private final String readDirection;
    private final boolean correctDirection;
    private final boolean bridgeEndPoint;

    public CompareResult(String readDirection, boolean correctDirection, boolean bridgeEndPoint) {
        this.readDirection = readDirection;
        this.correctDirection = correctDirection;
        this.bridgeEndPoint = bridgeEndPoint;
    }

    public boolean isCorrectDirection() {
        return correctDirection;
    }

    public String getReadDirection() {
        return readDirection;
    }

    public boolean isBridgeEndPoint() {
        return bridgeEndPoint;
    }

}
