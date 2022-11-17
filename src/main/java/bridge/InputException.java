package bridge;

import java.text.ParseException;

public class InputException {

    public static void validate(String bridgeSize) {
        checkParsingError(bridgeSize);
//        isNumber(bridgeSize);
    }

    private static void checkParsingError(String number) {
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(NumberFormatExceptionMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE.getNumberFormatExceptionMessage());
        }
    }

    // 에러 메세지 생성해야 됨
    private void isNumber(String bridgeSize) {
        int bridgeSizeCheck = Integer.parseInt(bridgeSize);
        if (!(3 <= bridgeSizeCheck && bridgeSizeCheck <= 20)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
