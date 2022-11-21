package bridge.view;

public class InputParser {

    public static final String NUMBER_REGEX = "^\\d+$";

    int parseNumber(String str) {
        if (!str.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }

        return Integer.parseInt(str);
    }
}
