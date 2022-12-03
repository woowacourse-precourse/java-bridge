package bridge;

import static bridge.Constant.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        int number = handleCheckLengthValidate(input);
        return handleCheckLengthRangeValidate(number);
    }

    private int checkLengthValidate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_STRING);
        }
    }

    public int handleCheckLengthValidate(String input) {
        try {
            return checkLengthValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_LENGTH_STRING);
            return readBridgeSize();
        }
    }

    private void checkLenghtRangeValidate(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_RANGE);
        }
    }

    public int handleCheckLengthRangeValidate(int number) {
        try {
            checkLenghtRangeValidate(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_LENGTH_RANGE);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        return handleCheckMoveValidate(input);
    }

    private String checkMoveValidate(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MOVE_STRING);
        }
        return input;
    }

    public String handleCheckMoveValidate(String input) {
        try {
            return checkMoveValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_MOVE_STRING);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        return handleCheckGameCommandValidate(input);
    }

    private String checkGameCommandValidate(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_GAME_COMMAND_STRING);
        }
        return input;
    }

    public String handleCheckGameCommandValidate(String input) {
        try {
            return checkGameCommandValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_GAME_COMMAND_STRING);
            return readGameCommand();
        }
    }
}
