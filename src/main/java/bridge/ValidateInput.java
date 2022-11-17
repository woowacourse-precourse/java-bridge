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

    public static boolean isAllDigit(String rawInput){
        boolean isDigit = Pattern.matches(regexPatterns.ONLY_DIGIT.regex, rawInput);
        if (!isDigit) {
            throw new IllegalArgumentException("숫자로만 구성되어야 합니다.");
        }
        return true;
    }

    public static boolean isInRange(String rawInput) { // "0004" 이런 입력은 올바른 입력으로 통과됨.
        int target = Integer.parseInt(rawInput);
        if (target < 3 || target > 20) {
            throw new IllegalArgumentException("3이상 20이하이어야 합니다.");
        }
        return true;
    }

    public static boolean isUorD(String rawInput){
        boolean isUorD = Pattern.matches(regexPatterns.U_OR_D.regex, rawInput);
        if (!isUorD){
            throw new IllegalArgumentException("이동은 U 또는 D만 가능합니다.");
        }
        return true;
    }

    public static boolean isRorQ(String rawInput){
        boolean isRorQ = Pattern.matches(regexPatterns.R_OR_Q.regex, rawInput);
        if (!isRorQ){
            throw new IllegalArgumentException("게임 재시작은 R, 종료는 Q를 입력해주세요.");
        }
        return true;
    }
}
