package bridge.view;

import bridge.validator.InputValidator;
import bridge.validator.Validatable;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements Validatable<String> {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = getInput();
        validate(input, InputValidator.IS_NUMBER);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMove() {
        String input = getInput();
        validate(input, InputValidator.IS_UPPERCASE_ALPHABET);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String getInput() {
        return Console.readLine();
    }

}
