package bridge.utils;

import bridge.exception.IllegalPositionInFormOfNumberException;

import static bridge.constant.BridgePosition.DOWN;
import static bridge.constant.BridgePosition.UP;

public class BridgePositionParser {

    public static String parsePositionToStringForm(int positionFormOfNumber) {
        if (positionFormOfNumber == UP.getPositionFormOfNumber()) {
            return UP.getPositionFormOfAlphabet();
        }
        if (positionFormOfNumber == DOWN.getPositionFormOfNumber()) {
            return DOWN.getPositionFormOfAlphabet();
        }
        throw new IllegalPositionInFormOfNumberException();
    }
}
