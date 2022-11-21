package bridge.util;

public class ValidationUtil {

    public static boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRange(int input, int start, int end) {
        if (input < start || input > end) {
            return false;
        }
        return true;
    }
}
