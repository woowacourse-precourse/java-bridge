package bridge.view;

import bridge.model.Direction;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            new InputValidator().validateSize(input);
        } catch (IllegalArgumentException exception) {
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    public Direction readMoving() {
        String input = Console.readLine();
        try {
            new InputValidator().validateMoving(input);
        } catch (IllegalArgumentException exception) {
            return readMoving();
        }
        return Direction.valueOf(input);
    }

    public String readGameCommand() {
        String input = Console.readLine();
        try {
            new InputValidator().validateGameCommand(input);
        } catch (IllegalArgumentException exception) {
            return readGameCommand();
        }
        return input;
    }
}
