package bridge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BridgeExceptionChecker {
    private static final Integer RANGE_LOWER_INCLUDED = 3;
    private static final Integer RANGE_UPPER_INCLUDED = 20;

    private static final String REGEX_NUMBER = "[+-]?[1-9]?\\d+";
    static void raiseExceptionIfIsNotNumber(String str) {
        Matcher matcher = Pattern.compile(REGEX_NUMBER).matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionPhrases.NOT_NUMBER.toString());
        }
    }

    static void raiseExceptionIfIsOutOfRange(String str) {
        int number = Integer.parseInt(str);
        if (number < RANGE_LOWER_INCLUDED || RANGE_UPPER_INCLUDED < number) {
            throw  new IllegalArgumentException(ExceptionPhrases.OUT_OF_RANGE.toString());
        }
    }
}
