package bridge.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BridgeLength {

    private static final String LENGTH_FORMAT = "^[1-2]?[1-9]$";
    private static final int MIN_LENGTH=3;
    private static final int MAX_LENGTH=20;
    private final int length;

    private BridgeLength(String length) {
        validateLength(length);
        this.length = Integer.parseInt(length);
    }

    public static BridgeLength createBridgeLength(String length){
        return new BridgeLength(length);
    }

    public int getLength() {
        return length;
    }

    public void validateLength(String length) {
        validateLengthNumber(length);
        validateLengthRange(length);
    }

    public void validateLengthNumber(String length) {
        if (isLengthNumberCorrect(length)) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.LENGTH_NON_NUMBER_ERROR_MESSAGE.getMessage());
    }

    private static boolean isLengthNumberCorrect(String length) {
        String regex = LENGTH_FORMAT;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(length);
        return matcher.matches();
    }

    public void validateLengthRange(String length) {
        if (isLengthRangeCorrect(length)) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.LENGTH_OVER_RANGE_ERROR_MESSAGE.getMessage());
    }

    private static boolean isLengthRangeCorrect(String length) {
        int lengthNumber = Integer.parseInt(length);
        return lengthNumber >= MIN_LENGTH && lengthNumber <= MAX_LENGTH;
    }
}
