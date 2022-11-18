package bridge.service;

import bridge.service.exception.BridgeSizeException;
import bridge.service.exception.DirectionException;
import bridge.service.exception.RetryException;

public class ExceptionService {

    public static void checkBridgeSize(String size) {
        BridgeSizeException.checkConvertToNumber(size);
        BridgeSizeException.checkBridgeSizeIsCorrectRange(size);
    }

    public static void checkMoving(String move) {
        DirectionException.checkMovingIsCorrectFormat(move);
    }

    public static void checkRetry(String retry) {
        RetryException.checkRetryIsCorrectFormat(retry);
    }
}
