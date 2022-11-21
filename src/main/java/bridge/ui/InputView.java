package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요";

    public int readBridgeSize() {
        String input = input();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    public String readCommand() {
        return input();
    }

    private static String input() {
        return Console.readLine();
    }
}
