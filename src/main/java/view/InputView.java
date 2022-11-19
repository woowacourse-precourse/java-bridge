package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final char UPPER_START = 'A';
    public static final char UPPER_END = 'Z';
    public static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력값이 아닙니다.";

    public int readBridgeSize() {
        String size = Console.readLine();
        checkNumberValidity(size);
        return Integer.parseInt(size);
    }

    private void checkNumberValidity(String size) throws IllegalArgumentException {
        if (size.length() != 1) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        char validLengthSize = size.charAt(0);
        if (Character.isDigit(validLengthSize) == false) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    public String readMoving() {
        String move = Console.readLine();
        CheckAlphabetValidity(move);
        return move;
    }

    public String readGameCommand() {
        String command = Console.readLine();
        CheckAlphabetValidity(command);
        return command;
    }

    private void CheckAlphabetValidity(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        char validLengthInput = input.charAt(0);
        if (!(validLengthInput >= UPPER_START
                && validLengthInput <= UPPER_END)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }
}
