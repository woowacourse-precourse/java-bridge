package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String inputValue = Console.readLine();
        validator.validateBridgeSize(inputValue);
        return Integer.parseInt(inputValue);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputValue = Console.readLine();
        validator.validateMoving(inputValue);
        return inputValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputValue = Console.readLine();
        validator.validateGameCommand(inputValue);
        return inputValue;
    }
}
