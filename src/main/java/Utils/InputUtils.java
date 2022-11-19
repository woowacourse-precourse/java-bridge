package Utils;

import bridge.EnumCollections.BridgeLengthType;
import bridge.EnumCollections.BridgeType;
import bridge.EnumCollections.GameRestartType;

public class InputUtils {

    public static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public static boolean isValidRangeDigit(String input) {
        int length = Integer.parseInt(input);
        return length >= BridgeLengthType.MIN.getLength() && length <= BridgeLengthType.MAX.getLength();
    }


    public static boolean isValidBridgePosition(String input) {
        return BridgeType.isPosition(input);
    }

    public static boolean isValidGameRestartInput(String input) {
        return GameRestartType.isRestartStatus(input);
    }
}
