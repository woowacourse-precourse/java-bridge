package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final char UPPER_START = 'A';
    public static final char UPPER_END = 'Z';
    public static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    public static boolean sizeFormatError;
    public static boolean moveFormatError;
    public static boolean commandFormatError;

    public int readBridgeSize() {
        String size = Console.readLine();
        sizeFormatError = false;
        try {
            checkNumberValidity(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            size = "0";
        }
        return Integer.parseInt(size);
    }

    private void checkNumberValidity(String size) throws IllegalArgumentException {
        if (size.length() == 0) {
            sizeFormatError = true;
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        for (int index = 0; index < size.length(); index++) {
            if (Character.isDigit(size.charAt(index)) == false) {
                sizeFormatError = true;
                throw new IllegalArgumentException(ERROR_INVALID_INPUT);
            }
        }
    }

    public String readMoving() {
        String move = Console.readLine();
        moveFormatError = false;
        try {
            CheckAlphabetValidity(move);
        } catch (IllegalArgumentException e) {
            moveFormatError = true;
            System.out.println(e.getMessage());
            move = null;
        }
        return move;
    }

    public String readGameCommand() {
        String command = Console.readLine();
        commandFormatError = false;
        try {
            CheckAlphabetValidity(command);
        } catch (IllegalArgumentException e) {
            commandFormatError = true;
            System.out.println(e.getMessage());
            command = null;
        }
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
