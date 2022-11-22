package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int BRIDGE_SIZE = 1;
    private static final int MOVING = 2;
    private static final int GAME_COMMAND = 3;
    private String input;

    public String readBridgeSize() {
        while (true) {
            input = repeatForValid(BRIDGE_SIZE);
            break;
        }
        return input;
    }

    private void checkInputObject(int method, String input) {
        if (BRIDGE_SIZE == method) {
            new BridgeSize(input);
            return;
        }
        if (MOVING == method) {
            new Moving(input);
            return;
        }
        new GameCommand(input);
    }

    private String checkInputMethod(int method) {
        if (BRIDGE_SIZE == method) {
            return readBridgeSize();
        }
        if (MOVING == method) {
            return readMoving();
        }
        return readGameCommand();
    }

    private String repeatForValid(int methodType) {
        try {
            input = Console.readLine();
            checkInputObject(methodType, input);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage() + " 다시 입력해주세요.\n");
            input = checkInputMethod(methodType);
        }
        return input;
    }

    public String readMoving() {
        while (true) {
            input = repeatForValid(MOVING);
            break;
        }
        return input;
    }

    public String readGameCommand() {
        while (true) {
            input = repeatForValid(GAME_COMMAND);
            break;
        }
        return input;
    }
}
