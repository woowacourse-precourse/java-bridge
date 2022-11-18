package bridge;

public class Bridge {

    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;

    private final int bridgeLength;

    public Bridge(int bridgeLength) {
        validateNumberRange(bridgeLength);
        this.bridgeLength = bridgeLength;
    }

    private void validateNumberRange(int bridgeLength) {
        if (bridgeLength < MINIMUM_BRIDGE_LENGTH || bridgeLength >MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_IS_THREE_TO_TWENTY.getErrorMessage());
        }
    }

    public int getBridgeLength() {
        return bridgeLength;
    }
}
