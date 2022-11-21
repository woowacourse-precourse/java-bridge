package bridge;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {

    private static final String ERROR_NUMBER_FORMAT = "숫자 형태로 입력해주세요.";

    public static int readInt() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
        }
    }

    public static String readString() {
        return Console.readLine();
    }
}
