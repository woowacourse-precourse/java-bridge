package bridge;

public class CompareResult {
    private final String readDirection;
    private final int bridgeLocation;
    private final boolean appropriate;

    public CompareResult(String readDirection, int bridgeLocation, boolean appropriate) {
        this.readDirection = readDirection;
        this.bridgeLocation = bridgeLocation;
        this.appropriate = appropriate;
    }

    public boolean isAppropriate() {
        return appropriate;
    }

    public String getReadDirection() {
        return readDirection;
    }

    public int getBridgeLocation() {
        return bridgeLocation;
    }

}
