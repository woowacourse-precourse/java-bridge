package bridge.view;

import bridge.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String enterBridgeSize = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(enterBridgeSize);
        String input = Console.readLine();
        validateDigit(input);
        return Integer.parseInt(input);
    }

    private void validateDigit(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw Exception.IS_NOT_NUMBER_EXCEPTION.getException();
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
