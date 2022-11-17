package view;

import camp.nextstep.edu.missionutils.Console;
import util.ErrorMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public int readBridgeSize() {
        String usersInput = Console.readLine();
        validateBridgeSize(usersInput);
        int bridgeSize = Integer.parseInt(usersInput);
        return bridgeSize;
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

    public void validateBridgeSize(String input){
        if (!isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT);
        }

    }
    private boolean isDigit(String input){
        if (!input.matches(NUMBER_REGEX)) {
            return false;
        }
        return true;
    }
}
