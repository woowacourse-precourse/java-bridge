package bridge.util;

import bridge.view.ExceptionView;

public class Utils {

    public static int inputToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionView.bridgeRangeError();
            throw new IllegalArgumentException();
        }
    }
}
