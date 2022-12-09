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
        if(input != "U" && input != "D") {
            throw new IllegalArgumentException("U 또는 D만 입력할 수 있습니다.");
        }
    }
}
