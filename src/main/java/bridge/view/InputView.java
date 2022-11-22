package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public String readBridgeSize() {
        System.out.println(InputMessage.BRIDGE_SIZE.message());
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println(InputMessage.MOVING.message());
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(InputMessage.GAME_COMMAND.message());
        return Console.readLine();
    }

    public static InputView getInstance() {
        return instance;
    }
}
