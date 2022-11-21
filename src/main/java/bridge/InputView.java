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

    private void checkLenghtRangeValidate(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_RANGE);
        }
    }
    private int handleCheckLengthValidate(String input) {
        try {
            return checkLengthValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_LENGTH_STRING);
            return readBridgeSize();
        }
    }

    private int handleCheckLengthRangeValidate(int number) {
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
        return null;
    }

//    public String checkMoveValidate(String input) {
//        if (!input.equals("U") || !input.equals("D")) {
//            throw new IllegalArgumentException(ERROR_MESSAGE_MOVE_STRING);
//        }
//        return null;
//    }
//
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
