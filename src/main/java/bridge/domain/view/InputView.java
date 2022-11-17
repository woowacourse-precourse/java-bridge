package bridge.domain.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    InputException inputException = new InputException();

    public int readBridgeSize() {
        String input = Console.readLine();
        inputException.inputBridgeLengthException(input);
        return Integer.parseInt(input);
    }

    public char readMoving() {
        String input = Console.readLine();
        inputException.inputMoveException(input);
        return input.charAt(0);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
