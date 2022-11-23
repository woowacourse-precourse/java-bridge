package utils;

import java.util.StringJoiner;

public class Common {
    public static int convertInputToNumber(String input) {
        int size = 0;
        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Error.generate(Message.NUMBER);
        }
        return size;
    }

    public static String formatToPrintMap(StringJoiner upperBridge, StringJoiner underBridge) {
        return upperBridge.toString() + "\n" + underBridge.toString();
    }
}
