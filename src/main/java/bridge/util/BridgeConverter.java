package bridge.util;

import static bridge.exception.ExceptionHandler.NO_SUCH_ELEMENT;

import bridge.constant.InputKeyConstant;
import java.util.Arrays;

public final class BridgeConverter {

    private BridgeConverter() {
    }

    public static String covertToBridgeNumber(int bridgeNumber) {
        String convertedBridgeNumber = null;

        try {
            convertedBridgeNumber = Arrays.stream(InputKeyConstant.values()).filter(i -> i.getCode() == bridgeNumber)
                                          .findAny().orElseThrow(ClassNotFoundException::new).getFirstLetter();
        } catch (ClassNotFoundException e) {
            NO_SUCH_ELEMENT.error();
        }

        return convertedBridgeNumber;
    }

}
