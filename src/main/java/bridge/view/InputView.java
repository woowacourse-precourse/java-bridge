package bridge.view;

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

    private String checkMethod(int method) {
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
            checkObject(methodType, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("다시 입력해주세요");
            input = checkMethod(methodType);
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
