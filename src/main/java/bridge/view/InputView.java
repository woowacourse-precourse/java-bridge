package bridge.view;

import bridge.constant.ErrorMessage;
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
        validateInputIsNumericFormat(input);
        return Integer.parseInt(input);
    }

    public void validateInputIsNumericFormat(String input){
        final String NUMERIC_REGULAR_EXPRESSION = "^[-]?[0-9]+$";
        if(!input.matches(NUMERIC_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_TYPE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        return input;
    }
}
