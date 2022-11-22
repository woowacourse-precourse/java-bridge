package bridge.view;

import bridge.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

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
