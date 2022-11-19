package bridge.view;

import bridge.util.InputConverter;
import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator;
    private final InputConverter inputConverter;

    public InputView() {
        this.inputValidator = new InputValidator();
        this.inputConverter = new InputConverter();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();
        inputValidator.validateBridgeSize(userInput);

        return inputConverter.toInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = Console.readLine();
        inputValidator.validateBridgeMove(userInput);

        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = Console.readLine();
        inputValidator.validateGameCommand(userInput);

        return userInput;
    }
}
