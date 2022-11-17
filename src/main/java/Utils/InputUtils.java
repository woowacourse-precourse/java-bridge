package Utils;

import bridge.EnumCollections.BridgeLengthType;
import bridge.EnumCollections.BridgeType;

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
        return length >= BridgeLengthType.MIN.getLength() && length <= BridgeLengthType.MAX.getLength();
    }


    public boolean isValidBridgePosition(String input) {
        char characterInput = input.charAt(0);
        return BridgeType.isPosition(characterInput);
    }




}
