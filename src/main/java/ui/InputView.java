package ui;

import camp.nextstep.edu.missionutils.Console;
import bridge.CustomException;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String PROMPT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private final String PROMPT_USER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String PROMPT_RESTART_OR_END = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        try {
            return inputToInteger(validBridgeNumber(promptInput(PROMPT_BRIDGE_LENGTH)));
        } catch (IllegalArgumentException exception) {
            errorPrinter(exception);
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            return validMoving(promptInput(PROMPT_USER_MOVE));
        } catch (IllegalArgumentException exception) {
            errorPrinter(exception);
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            return validCommand(promptInput(PROMPT_RESTART_OR_END));
        } catch (IllegalArgumentException exception) {
            errorPrinter(exception);
            return readGameCommand();
        }
    }

    private String promptInput(String message) {
        promptPrinter(message);
        try {
            return validInput(Console.readLine());
        } catch (IllegalArgumentException exception) {
            errorPrinter(exception);
            return promptInput(message);
        }
    }

    private void promptPrinter(String message) {
        System.out.println(message);
    }

    private void errorPrinter(Exception e) {
        System.out.println(e.getMessage());
    }

    private int inputToInteger(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum *= 10;
            sum += input.charAt(i) - '0';
        }
        return sum;
    }

    private String validBridgeNumber(String input) {
        validateNotStartWithZero(input);
        validateOnlyNumber(input);
        validateNumberRange(input);
        return input;
    }

    private String validMoving(String input) {
        validateCommandLength(input);
        validateMovingCommand(input);
        return input;
    }

    private String validCommand(String input) {
        validateCommandLength(input);
        validateGameCommand(input);
        return input;
    }

    private String validInput(String input) {
        validateNotNull(input);
        validateNotBlank(input);
        return input;
    }

    private void validateNotNull(String input) {
        if (input == null) {
            CustomException.InputNotNullException();
        }
    }

    private void validateNotBlank(String input) {
        if (input.length() == 0 || input.strip().length() == 0) {
            CustomException.NotBlankException();
        }
    }

    private void validateOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                CustomException.NotNumberException();
            }
        }
    }

    private void validateNotStartWithZero(String input) {
        if (input.startsWith("0")) {
            CustomException.StartWithZeroException();
        }
    }

    private void validateNumberRange(String input) {
        if (input.length() > 2) {
            CustomException.NotNumberRangeException();
        } else if (input.length() == 1 && input.charAt(0) <= '2') {
            CustomException.NotNumberRangeException();
        } else if (input.length() == 2 && input.charAt(0) > '2') {
            CustomException.NotNumberRangeException();
        }
    }

    private void validateCommandLength(String input) {
        if (input.length() != 1) {
            CustomException.CommandLengthException();
        }
    }

    private void validateMovingCommand(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            CustomException.NoSuchMovingException();
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            CustomException.NoSuchCommandException();
        }
    }

}
