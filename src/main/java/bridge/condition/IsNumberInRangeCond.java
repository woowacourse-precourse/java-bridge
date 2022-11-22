package bridge.condition;

import bridge.exception.OutOfRangeException;

import java.util.Arrays;

public class IsNumberInRangeCond implements Condition {

    private static final Condition instance = new IsNumberInRangeCond();
    private static final Integer LOWER_BOUND = 3;
    private static final Integer UPPER_BOUND = 20;

    private IsNumberInRangeCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public boolean test(String input) {
        return isNumeric(input) && isInRange(input);
    }

    @Override
    public IllegalArgumentException getException() {
        return new OutOfRangeException();
    }

    private boolean isNumeric(String input) {
        return Arrays.stream(input.split("")).allMatch((String digit) -> Character.isDigit(digit.charAt(0)));
    }

    private boolean isInRange(String input) {
        return LOWER_BOUND <= Integer.parseInt(input) && Integer.parseInt(input) <= UPPER_BOUND;
    }
}
