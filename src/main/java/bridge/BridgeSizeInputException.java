package bridge;

public class BridgeSizeInputException {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public static void validateBridgeSize(String bridgeSize) {
        checkParsingError(bridgeSize);
        isNumber(bridgeSize);
    }

    private static void checkParsingError(String number) {
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(BridgeSizeInputExceptionMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE.getBridgeSizeInputExceptionMessage());
        }
    }

    // 에러 메세지 생성해야 됨
    private static void isNumber(String bridgeSize) {
        int bridgeSizeCheck = Integer.parseInt(bridgeSize);
        if (!(MIN_BRIDGE_SIZE <= bridgeSizeCheck && bridgeSizeCheck <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(BridgeSizeInputExceptionMessage.NUMBER_RANGE_EXCEPTION_MESSAGE.getBridgeSizeInputExceptionMessage());
        }
    }
}
