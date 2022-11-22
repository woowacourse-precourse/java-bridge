package bridge.utils;

public class Converter {

    public static String convertToOX(boolean answer) {
        if (answer) {
            return "O";
        }
        return "X";
    }

    public static int convertToIndex(String moving) {
        if (moving.equals("U")) {
            return 0;
        }
        return 1;
    }
}
