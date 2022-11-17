package bridge.view.console;

import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static int readNumber() {
        String value = Console.readLine();
        ReaderValidator.validateNumber(value);
        return Integer.parseInt(value);
    }

    public static String readString() {
        String value = Console.readLine();
        ReaderValidator.validateString(value);
        return value;
    }


    static class ReaderValidator extends Validator {
        public static void validateNumber(String value) {
            validateNotNull(value);
            validateNotEmpty(value);
            validateInteger(value);
        }

        public static void validateString(String value) {
            validateNotNull(value);
            validateNotEmpty(value);
        }
    }
}
