package bridge.validator;

import static bridge.constant.Rules.MAX_BRIDGE_SIZE;
import static bridge.constant.Rules.MIN_BRIDGE_SIZE;

import bridge.exception.WrongBridgeSizeException;

public class BridgeValidator {

    public static void validateBridgeSize(String size) {
        if (!verifyPositiveInteger(size)) {
            throw new WrongBridgeSizeException();
        }
        int sizeValue = Integer.parseInt(size);
        if (!verifyRange(sizeValue)) {
            throw new WrongBridgeSizeException();
        }
    }

    private static boolean verifyPositiveInteger(String size) {
        return size != null && size.matches("^[1-9]\\d{0,8}");
    }

    private static boolean verifyRange(int size) {
        return size >= MIN_BRIDGE_SIZE && size <= MAX_BRIDGE_SIZE;
    }
}
