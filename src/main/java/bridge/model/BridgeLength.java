package bridge.model;

import bridge.constant.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BridgeLength {

    private static final Pattern pattern = Pattern.compile("^[0-9]+$");
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private final int length;

    private BridgeLength(String length) {
        validateLength(length);
        this.length = Integer.parseInt(length);
    }

    public static BridgeLength createBridgeLength(String length) {
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
        throw new IllegalArgumentException(ErrorMessage.LENGTH_NON_NUMBER_ERROR_MESSAGE.getMessage());
    }

    private static boolean isLengthNumberCorrect(String length) {
        Matcher matcher = pattern.matcher(length);
        return matcher.matches();
    }

    public void validateLengthRange(String length) {
        if (isLengthRangeCorrect(length)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER_RANGE_ERROR_MESSAGE.getMessage());
    }

    private static boolean isLengthRangeCorrect(String length) {
        int lengthNumber = Integer.parseInt(length);
        return lengthNumber >= MIN_LENGTH && lengthNumber <= MAX_LENGTH;
    }
}
