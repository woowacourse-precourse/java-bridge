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

    private enum ErrorMassage{
        DIGIT_ONLY("숫자로만 구성되어야 합니다."),
        NOT_IN_RANGE("3이상 20이하이어야 합니다."),
        NOT_U_OR_D("이동은 U 또는 D만 가능합니다."),
        NOT_R_OR_Q("게임 재시작은 R, 종료는 Q를 입력해주세요.");

        final String line;

        ErrorMassage(String line){
            this.line = line;
        }
    }

    /**
     *
     * @param rawInput 사용자의 입력값
     * @return 입력이 숫자로만 이루어졌다면 true, 아닐시 IllegalArgumentException 에러
     */
    public static boolean isAllDigit(String rawInput){
        boolean isDigit = Pattern.matches(regexPatterns.ONLY_DIGIT.regex, rawInput);
        if (!isDigit) {
            throw new IllegalArgumentException(ErrorMassage.DIGIT_ONLY.line);
        }
        return true;
    }

    /**
     *
     * @param rawInput 사용자의 입력값
     * @return 입력이 3이상 20이하의 숫자라면 true, 아닐시 IllegalArgumentException 에러
     */
    public static boolean isInRange(String rawInput) { // "0004" 이런 입력은 올바른 입력으로 통과됨.
        int target = Integer.parseInt(rawInput);
        if (target < 3 || target > 20) {
            throw new IllegalArgumentException(ErrorMassage.NOT_IN_RANGE.line);
        }
        return true;
    }

    /**
     *
     * @param rawInput 사용자의 입력값
     * @return 입력이 "U" 또는 "D" 라면 true, 아닐시 IllegalArgumentException 에러
     */
    public static boolean isUorD(String rawInput){
        boolean isUorD = Pattern.matches(regexPatterns.U_OR_D.regex, rawInput);
        if (!isUorD){
            throw new IllegalArgumentException(ErrorMassage.NOT_U_OR_D.line);
        }
        return true;
    }

    /**
     *
     * @param rawInput 사용자의 입력값
     * @return 입력이 "R" 또는 "Q" 라면 true, 아닐시 IllegalArgumentException 에러
     */
    public static boolean isRorQ(String rawInput){
        boolean isRorQ = Pattern.matches(regexPatterns.R_OR_Q.regex, rawInput);
        if (!isRorQ){
            throw new IllegalArgumentException(ErrorMassage.NOT_R_OR_Q.line);
        }
        return true;
    }
}
