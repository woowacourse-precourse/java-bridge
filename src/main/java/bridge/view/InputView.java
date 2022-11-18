package bridge.view;

import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String readLine() {
        return Console.readLine().strip();
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = readLine();
        validateMovingCommand(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateBridgeSize(String input) {
        Validator.validateBlank(input);
        Validator.validateInteger(input);
    }

    private void validateMovingCommand(String input) {
        Validator.validateBlank(input);
        Validator.validateMovingCommandLength(input);
        Validator.validateMovingCommand(input);
    }
}
