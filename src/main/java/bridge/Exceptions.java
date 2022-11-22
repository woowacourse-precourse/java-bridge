package bridge;

public class Exceptions {
    public static String isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return input;
    }

    public static String isUOrD(String input) {
        if (!(input.equals("U")) && !(input.equals("D"))) {
            throw new IllegalArgumentException("U 또는 D만 입력할 수 있습니다.");
        }
        return input;
    }

    public static String isROrQ(String input) {
        if (!(input.equals("R")) && !(input.equals("Q"))) {
            throw new IllegalArgumentException("R 또는 Q만 입력할 수 있습니다.");
        }
        return input;
    }
}
