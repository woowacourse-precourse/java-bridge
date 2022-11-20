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
        return handleCheckLengthValidate(input);
    }

    private int checkLengthValidate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_STRING);
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

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
