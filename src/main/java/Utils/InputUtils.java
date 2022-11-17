package Utils;

import bridge.EnumCollections.BridgeLengthType;

public class InputUtils {

    public boolean isDigit(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public boolean isValidRangeDigit(String input) {
        int length = Integer.parseInt(input);
        int min = BridgeLengthType.MIN.getLength();
        int max = BridgeLengthType.MAX.getLength();

        return length >= min && length <= max;
    }


}
