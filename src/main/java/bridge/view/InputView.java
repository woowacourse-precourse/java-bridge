package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    Validator validator = new Validator();

    public int readBridgeSize() {
        String bridgeSize = readLine();
        try {
            validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = readLine();
        try {
            validator.validateMoving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return moving;
    }

    public String readGameCommand() {
        String command = readLine();
        try {
            validator.validateGameCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return command;
    }
}
