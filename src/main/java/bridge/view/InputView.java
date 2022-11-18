package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    Validator validator = new Validator();

    public int readBridgeSize() {
        String bridgeSize = readLine();
        validator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = readLine();
        validator.validateMoving(moving);
        return moving;
    }

    public String readGameCommand() {
        String command = readLine();
        validator.validateGameCommand(command);
        return command;
    }
}
