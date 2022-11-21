package bridge.verifier;

import bridge.system.ExceptionMessage;

import java.math.BigInteger;

public class BridgeSizeVerifier {
    private final int BRIDGE_SIZE_LOWERBOUND = 3;
    private final int BRIDGE_SIZE_UPPERBOUND = 20;

    public void check(String target) {
        checkNumeric(target);
        checkIntegerRange(target);
        checkRange(target);
    }

    private void checkNumeric(String target) {
        try {
            new BigInteger(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    private void checkIntegerRange(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_TYPE_RANGE);
        }
    }

    private void checkRange(String target) {
        int bridgeSize = Integer.parseInt(target);
        if (bridgeSize < BRIDGE_SIZE_LOWERBOUND || bridgeSize > BRIDGE_SIZE_UPPERBOUND) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
    }
}
