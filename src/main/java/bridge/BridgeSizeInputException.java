package bridge;

public class BridgeSizeInputException {

    public static void validate(String bridgeSize) {
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
        if (!(3 <= bridgeSizeCheck && bridgeSizeCheck <= 20)) {
            throw new IllegalArgumentException(BridgeSizeInputExceptionMessage.NUMBER_RANGE_EXCEPTION_MESSAGE.getBridgeSizeInputExceptionMessage());
        }
    }
}
