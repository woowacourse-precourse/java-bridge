package bridge.Utils;

import bridge.Constant.Error;
import bridge.Constant.Regex;
import bridge.View.OutputView;

public class Verification {

    public static boolean isBridgeNum(final String size) {
        return verify(size, Regex.NUMBER.verify(), Error.NUMBER.printError()) &&
            verify(size, Regex.THREE_TO_TWENTY.verify(), Error.THREE_TO_TWENTY.printError());
    }

    public static boolean isMoveKey(final String input) {
        return verify(input, Regex.MOVE_KEY.verify(), Error.MOVE.printError());
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
