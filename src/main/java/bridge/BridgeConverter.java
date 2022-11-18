package bridge;

import static bridge.exception.ExceptionHandler.NO_SUCH_ELEMENT;

import java.util.Arrays;

public class BridgeConverter {

    private BridgeConverter() {
    }

    public static String covertToBridgeNumber(int bridgeNumber) {
        try {
            return Arrays.stream(KeyBoardEvent.values())
                         .filter(i -> i.getCode() == bridgeNumber)
                         .findAny()
                         .orElseThrow(ClassNotFoundException::new)
                         .getFirstLetter();
        } catch (ClassNotFoundException e) {
            NO_SUCH_ELEMENT.error();
        }
        return null;
    }

}
