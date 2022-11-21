package bridge.util;

import bridge.error.ErrorMessage;

public class Validator {
    static final int MIN_SIZE = 3;
    static final int MAX_SIZE = 20;
    static final String UP = "U";
    static final String DOWN = "D";
    static final String RESTART = "R";
    static final String QUIT = "Q";

    private Validator() {}

    /**
    * 입력값이 숫자로 변환이 된다면 변환한 값을 반환하고, 그렇지 않으면 예외를 반환한다.
    * @return int
    * */
    public static int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_BRIDGE_SIZE.getMessage());
        }
    }

    /**
     * 입력값이 3 ~ 20 사이가 아니라면 예외를 반환한다.
     * */
    public static void isInRange(int number) {
        if (MIN_SIZE > number || number > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    /**
     * 입력값이 한 문자가 아니라면 예외를 반환한다.
     * */
    public static void isOneStringMoving(String moving) {
        if (moving.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONE_STRING_MOVING.getMessage());
        }
    }

    /**
    * 입력값이 대문자가 아니라면 예외를 반환한다.
    * */
    public static void isUppercaseMoving(String moving) {
        if (!Character.isUpperCase(moving.charAt(0))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UPPER_CASE_MOVING.getMessage());
        }
    }

    /**
     * 입력값이 U 또는 D가 아니라면 예외를 반환한다.
     * */
    public static void isUpOrDown(String input) {
        if (!(input.equals(UP) || input.equals(DOWN))) {
            throw new IllegalArgumentException(ErrorMessage.U_OR_D_MOVING.getMessage());
        }
    }

    /**
     * 입력값이 한 문자가 아니라면 예외를 반환한다.
     * */
    public static void isOneStringCommand(String command) {
        if (command.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONE_STRING_COMMAND.getMessage());
        }
    }

    /**
     * 입력값이 대문자가 아니라면 예외를 반환한다.
     * */
    public static void isUppercaseCommand(String command) {
        if (!Character.isUpperCase(command.charAt(0))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UPPER_CASE_COMMAND.getMessage());
        }
    }

    /**
     * 입력값이 R 또는 Q가 아니라면 예외를 반환한다.
     * */
    public static void isRestartOrQuit(String input) {
        if (!(input.equals(RESTART) || input.equals(QUIT))) {
            throw new IllegalArgumentException(ErrorMessage.R_OR_Q_COMMAND.getMessage());
        }
    }
}
