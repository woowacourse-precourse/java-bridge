package bridge.view;

import bridge.domain.stringenum.PrintMessage;
import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printMessage(PrintMessage.BRIDGE_LENGTH.printMessage());
        return readNumber(Console.readLine());
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

    private int readNumber(String input) throws IllegalArgumentException {
        InputValidator.validateNumber(input);
        return Integer.parseInt(input);
    }

    private void printMessage(String requestMessage) {
        System.out.println(requestMessage);
    }

}
