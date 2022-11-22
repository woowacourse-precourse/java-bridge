package bridge.Utils;

import bridge.Constant.Error;
import bridge.Constant.Regex;
import bridge.View.OutputView;

public class Verification {

    public static boolean isBridgeNum(final String size) {
        return verify(size, Regex.NUMBER.verify(), Error.NUMBER.printError());
    }

    private static boolean verify(final String input, final String value, final String error) {
        try {
            if (!input.matches(value)) {
                throw new IllegalArgumentException(error);
            }
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }
}
