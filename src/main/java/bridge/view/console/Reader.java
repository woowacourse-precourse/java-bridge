package bridge.view.console;

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
}
