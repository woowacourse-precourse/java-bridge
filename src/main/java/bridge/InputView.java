package bridge;

import bridge.constant.InputValidationError;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputValidator validator;

    public InputView() {
        this.validator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String cmd = Console.readLine();
        int size;
        try {
            size = Integer.parseInt(cmd);
        } catch (NumberFormatException e) {
            throw InputValidationError.ERROR_BRIDGE_SIZE.exception;
        }
        validator.validateBridgeSize(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String cmd = Console.readLine();
        validator.validateMove(cmd);
        return cmd;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String cmd = Console.readLine();
        validator.validateGameCommand(cmd);
        return cmd;
    }
}
