package bridge;

import java.util.regex.Pattern;

public class ValidateInput {
    private enum regexPatterns{
        ONLY_DIGIT("^[0-9]+$"),
        U_OR_D("^[UD]$"),
        R_OR_Q("^[RQ]$");

        final String regex;

        regexPatterns(String regex){
            this.regex = regex;
        }
    }

//    public static void isAllDigit(String rawInput){
//        boolean isDigit = Pattern.matches(regexPatterns.ONLY_DIGIT.regex, rawInput);
//        if (!isDigit) {
//            throw new IllegalArgumentException();
//        }
//    }

    public static boolean isAllDigit(String rawInput){
        boolean isDigit = Pattern.matches(regexPatterns.ONLY_DIGIT.regex, rawInput);
        if (!isDigit) {
            throw new IllegalArgumentException("숫자로만 구성되어야 합니다.");
        }
        return true;
    }

//    public static void isInRange(String rawInput) { // "0004" 이런 입력은 올바른 입력으로 통과됨.
//        int target = Integer.parseInt(rawInput);
//        if (target < 3 || target > 20) {
//            throw new IllegalArgumentException();
//        }
//    }

    public static boolean isInRange(String rawInput) { // "0004" 이런 입력은 올바른 입력으로 통과됨.
        int target = Integer.parseInt(rawInput);
        if (target < 3 || target > 20) {
            throw new IllegalArgumentException("3이상 20이하이어야 합니다.");
        }
        return true;
    }

    public static void isUorD(String rawInput){
        boolean isUorD = Pattern.matches(regexPatterns.U_OR_D.regex, rawInput);
        if (!isUorD){
            throw new IllegalArgumentException();
        }
    }

    public static void isRorQ(String rawInput){
        boolean isRorQ = Pattern.matches(regexPatterns.R_OR_Q.regex, rawInput);
        if (!isRorQ){
            throw new IllegalArgumentException();
        }
    }
}
