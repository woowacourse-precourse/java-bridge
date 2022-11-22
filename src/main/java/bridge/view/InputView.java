package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.utils.Constants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String input;

    public String readBridgeSize() {
        while (true) {
            input = repeatForValid(Constants.BRIDGE_SIZE);
            break;
        }
        return input;
    }

    public String readMoving() {
        while (true) {
            input = repeatForValid(Constants.MOVING);
            break;
        }
        return input;
    }

    public String readGameCommand() {
        while (true) {
            input = repeatForValid(Constants.GAME_COMMAND);
            break;
        }
        return input;
    }
    
    private String repeatForValid(int methodType) {
        try {
            input = Console.readLine();
            checkInputObject(methodType, input);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage() + Constants.RE_ENTER_MESSAGE);
            input = checkInputMethod(methodType);
        }
        return input;
    }

    private void checkInputObject(int method, String input) {
        if (Constants.BRIDGE_SIZE == method) {
            new BridgeSize(input);
            return;
        }
        if (Constants.MOVING == method) {
            new Moving(input);
            return;
        }
        new GameCommand(input);
    }

    private String checkInputMethod(int method) {
        if (Constants.BRIDGE_SIZE == method) {
            return readBridgeSize();
        }
        if (Constants.MOVING == method) {
            return readMoving();
        }
        return readGameCommand();
    }
}
