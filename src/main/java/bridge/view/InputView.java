package bridge.view;

import bridge.domain.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public int readBridgeSize() {
        String bridgeSize = Console.readLine().trim();
        validator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = Console.readLine().trim();
        validator.validateMoving(moving);
        return moving;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine().trim();
        validator.validateGameCommand(gameCommand);
        return gameCommand;
    }
}
