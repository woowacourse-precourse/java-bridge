package ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String PROMPT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private final String PROMPT_USER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String PROMPT_RESTART_OR_END = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String ERROR_HEAD = "[ERROR] ";
    private final String NOT_NULL = "NULL 불가.";
    private final String NOT_BLANK = "Blank 불가.";
    private final String NOT_NUMBER = "숫자가 아닙니다.";
    private final String NOT_START_ZERO = "숫자는 0으로 시작 X";
    private final String OUT_OF_RANGE = "범위 초과";
    private final String OUT_OF_COMMAND_RANGE = "명령의 길이가 다릅니다.";
    private final String NOT_MOVING_COMMAND = "유효하지 않은 이동 명령";
    private final String NOT_QUIT_RETRY = "유효하지 않은 게임 명령입니다.";

    public int readBridgeSize() {
        try {
            String input = userInput(PROMPT_BRIDGE_LENGTH);
            validBridgeNumber(input);
            return inputToInteger(input);
        } catch (Exception e) {
            System.out.println(e);
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            String input = userInput(PROMPT_USER_MOVE);
            validMoving(input);
            return input;
        } catch (Exception e) {
            System.out.println(e);
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String input = userInput(PROMPT_RESTART_OR_END);
            validCommand(input);
            return input;
        } catch (Exception e) {
            System.out.println(e);
            return readGameCommand();
        }
    }

    private String userInput(String message) {
        promptPrinter(message);
        String input = Console.readLine();
        validateNotNull(input);
        validateNotBlank(input);
        return input;
    }

    private int inputToInteger(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum *= 10;
            sum += input.charAt(i) - '0';
        }
        return sum;
    }

    private void promptPrinter(String message) {
        System.out.println(message);
    }

    private void validBridgeNumber(String input) {
        validateNotStartWithZero(input);
        validateOnlyNumber(input);
        validateNumberRange(input);
    }

    private void validCommand(String input) {
        validateCommandLength(input);
        validateGameCommand(input);
    }

    private void validMoving(String input) {
        validateCommandLength(input);
        validateMovingCommand(input);
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_HEAD + NOT_NULL);
        }
    }

    private void validateNotBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(ERROR_HEAD + NOT_BLANK);
        }
    }

    private void validateOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException(ERROR_HEAD + NOT_NUMBER);
            }
        }
    }

    private void validateNotStartWithZero(String input) {
        //startWith?
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException(ERROR_HEAD + NOT_START_ZERO);
        }
    }

    private void validateNumberRange(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_RANGE);
        } else if (input.length() == 1 && input.charAt(0) <= '2') {
            throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_RANGE);
        } else if (input.length() == 2 && input.charAt(0) > '2') {
            throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_RANGE);
        }
    }

    private void validateCommandLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_COMMAND_RANGE);
        }
    }

    private void validateMovingCommand(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ERROR_HEAD + NOT_MOVING_COMMAND);
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ERROR_HEAD + NOT_QUIT_RETRY);
        }
    }

}
