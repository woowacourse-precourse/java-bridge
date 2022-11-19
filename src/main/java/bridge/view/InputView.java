package bridge.view;

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Validation validation = new Validation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = getString();
        while (!validation.isvValidBridgeSizeInput(input)) {
            input = getString();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = getString();
        while (!validation.isValidMoveInput(input)) {
            input = getString();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = getString();
        while (!validation.isValidGameCommand(input)) {
            input = getString();
        }
        return input;
    }

    private String getString() {
        return Console.readLine();
    }
}
