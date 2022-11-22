package bridge.model;

import bridge.util.BridgeGameExceptionMessage;
import java.math.BigInteger;

public class BridgeSize {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;
    private final int size;

    public BridgeSize(String size) {
        validate(size);
        this.size = Integer.parseInt(size);
    }

    private void validate(String size) {
        if (!hasNumber(size) || !acceptsSizeRange(size)) {
            throw new IllegalArgumentException(BridgeGameExceptionMessage.BRIDGE_SIZE_NUMBER_RANGE.getMessage());
        }
    }

    private boolean hasNumber(String size) {
        try {
            new BigInteger(size);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean acceptsSizeRange(String size) {
        BigInteger bigInteger = new BigInteger(size);
        return bigInteger.compareTo(BigInteger.valueOf(MIN_SIZE)) >= 0
                && bigInteger.compareTo(BigInteger.valueOf(MAX_SIZE)) <= 0;
    }

    public int getSize() {
        return size;
    }
}
