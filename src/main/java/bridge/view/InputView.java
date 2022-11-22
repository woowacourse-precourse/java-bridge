package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ERROR = "[ERROR] ";
    private static final String NUMBER_FORMAT_ERROR = ERROR + "숫자를 입력해주세요.";

    public int readBridgeSize() {
        return convert(input());
    }

    public String readMoving() {
        return input();
    }

    public String readGameCommand() {
        return input();
    }

    public int convert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
