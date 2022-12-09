package bridge;

public class Exception {
    public static void isNum(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isDigit(c))) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }
        }
    }

    public static void isUorD(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("U 또는 D만 입력할 수 있습니다.");
        }
    }

    public static void isRorQ(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("R 또는 Q만 입력할 수 있습니다.");
        }
    }
}
