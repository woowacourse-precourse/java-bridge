package bridge;

import java.util.regex.Pattern;

public class BridgeSize {

    private static final String BRIDGE_LENGTH_IS_DIGIT_EXCEPTION_MESSAGE = "[ERROR] 다리의 길이는 숫자값이여야 합니다.";
    private static final String BRIDGE_LENGTH_STARTS_WITH_ONE_TO_NINE_EXCEPTION_MESSAGE = "[ERROR] 다리의 길이의 시작값은 1부터 9까지의 숫자여야 합니다.";
    private static final String BRIDGE_LENGTH_RANGE_EXCEPTION_MESSAGE = "[ERROR] 다리의 길이의 범위는 3부터 20까지의 숫자여야 합니다.";
    private static final String REGEX_FOR_CHECKING_START_NUMBER_BETWEEN_ONE_TO_NINE = "^[1-9]\\d*$";
    private static final int BRIDGE_LENGTH_MIN = 3;
    private static final int BRIDGE_LENGTH_MAX = 20;

    private final int bridgeSize;

    public BridgeSize(String number) {
        isDigitExceptionCheck(number);
        startsWithOneToNineExceptionCheck(number);
        int bridgeSize = Integer.parseInt(number);
        outOfRangeExceptionCheck(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private void outOfRangeExceptionCheck(int bridgeSize) {
        boolean bridgeLengthRangeCheckResult = bridgeLengthRangeCheck(bridgeSize);
        if(!bridgeLengthRangeCheckResult) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean bridgeLengthRangeCheck(int bridgeSize) {
        return bridgeSize >= BRIDGE_LENGTH_MIN && bridgeSize <= BRIDGE_LENGTH_MAX;
    }

    private void startsWithOneToNineExceptionCheck(String number) {
        boolean startsWithOneToNineCheckResult = startsWithOneToNineCheck(number);
        if(!startsWithOneToNineCheckResult) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_STARTS_WITH_ONE_TO_NINE_EXCEPTION_MESSAGE);
        }
    }

    private boolean startsWithOneToNineCheck(String number) {
        return Pattern.matches(REGEX_FOR_CHECKING_START_NUMBER_BETWEEN_ONE_TO_NINE, number);
    }

    private void isDigitExceptionCheck(String number) {
        boolean isDigitCheckResult = isDigitCheck(number);
        if(!isDigitCheckResult) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_IS_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isDigitCheck(String number) {
        return number.chars()
                .mapToObj(i -> (char) i)
                .allMatch(Character::isDigit);
    }
}
