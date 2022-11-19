package bridge.utils;

public class Converter {
    public int toIntFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static String toStringFromInt(int input) {
        return Integer.toString(input);
    }
}
