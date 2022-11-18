package bridge.service;

import bridge.service.exception.BridgeSizeException;

public class ExceptionService {
    private static final String START_ERROR_MESSAGE = "[ERROR] ";

    public static void checkBridgeSize(String size) {
        BridgeSizeException.checkConvertToNumber(size);
        BridgeSizeException.checkBridgeSizeIsCorrectRange(size);
    }

    public static void checkMoving(String move) {

    }

    public static void checkRetry(String retry) {

    }
}
