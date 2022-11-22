package bridge.util;

import static bridge.exception.ExceptionMessages.InvalidNumberMessage;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    private ConsoleInput() {
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InvalidNumberMessage);
        }
    }

    public static String readLine() {
        return Console.readLine();
    }
}
