package bridge.condition;

import java.util.Arrays;

public class IsNumberInRangeCond implements Condition {

    private static final Integer LOWER_BOUND = 3;
    private static final Integer UPPER_BOUND = 20;

    @Override
    public boolean test(String input) {
        return isNumeric(input) && isInBound(input);
    }

    public boolean isNumeric(String input) {
        return Arrays.stream(input.split("")).allMatch((String digit) -> Character.isDigit(digit.charAt(0)));
    }

    public boolean isInBound(String input) {
        return LOWER_BOUND <= Integer.parseInt(input) && Integer.parseInt(input) <= UPPER_BOUND;
    }
}
