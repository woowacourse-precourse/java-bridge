package bridge.exception;

import static bridge.exception.InputExceptionMessage.*;

public class Validator {
    public static void isNull(Object number) {
        if (number == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION.message());
        }
    }

    public static void isNumber(String number) {
        isNull(number);
        if (!number.matches("[-+]?\\d*?\\d+")) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION.message());
        }
    }

    public static void inRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION.message());
        }
    }
}
