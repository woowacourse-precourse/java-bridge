package bridge.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {

    private static final String ERROR_NUMBER_FORMAT = "숫자 형태로 변환할 수 없는 입력입니다.";

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
