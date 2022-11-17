package bridge;

import java.util.regex.Pattern;

public class ValidateInput {
    private enum regexPatterns{
        ONLY_DIGIT("^[0-9]*$");

        final String regex;

        regexPatterns(String regex){
            this.regex = regex;
        }
    }

    public static void isAllDigit(String rawInput){
        boolean isDigit = Pattern.matches(regexPatterns.ONLY_DIGIT.regex, rawInput);
        if (!isDigit) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInRange(String rawInput) {
        int target = Integer.parseInt(rawInput);
        if (target < 3 || target > 20) {
            throw new IllegalArgumentException();
        }
    }
}
