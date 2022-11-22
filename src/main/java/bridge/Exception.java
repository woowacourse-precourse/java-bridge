package bridge;

public class Exception {

    public static void validateByNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
    }

    public static void validateByNotNumber(String input) {
        if (!StringUtil.isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateByOverRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하입니다.");
        }
    }

    public static void validateByNotUOrD(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U, D만 입력해주세요.");
        }
    }

    public static void validateByNotROrQ(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R, Q만 입력해주세요.");
        }
    }
}
