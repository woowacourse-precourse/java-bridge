package bridge.view;

import bridge.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSize = getInput();

        Validator.validateBridgeSize(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = getInput();

        Validator.validateMoving(moving);

        return moving;
    }

    public String readGameCommand() {
        String gameCommand = getInput();

        Validator.validateGameCommand(gameCommand);

        return gameCommand;
    }

    private String getInput() {
        return Console.readLine();
    }
}
