package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요";
    private static final String UP_DOWN_COMMAND_ERROR = "[ERROR] U 또는 D 를 입력해 주세요";
    private static final String RESTART_QUIT_ERROR = "[ERROR] R 또는 Q 를 입력해 주세요";
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    public String readMoving() {
        String input = Console.readLine();
        checkUpDown(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        checkRestartStop(input);
        return input;
    }

    private void checkUpDown(String input) {
        if (!input.equals(UP_COMMAND) && !input.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException(UP_DOWN_COMMAND_ERROR);
        }
    }

    private void checkRestartStop(String input) {
        if (!input.equals(RESTART_COMMAND) && !input.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(RESTART_QUIT_ERROR);
        }
    }
}
