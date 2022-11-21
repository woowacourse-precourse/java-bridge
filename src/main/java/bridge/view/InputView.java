package bridge.view;

import bridge.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        out(InputMessage.START_GAME);
        blank();
        out(InputMessage.INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        blank();
        return input;
    }

    public String readMoving() {
        out(InputMessage.INPUT_MOVING);
        String input = Console.readLine();
        return input;
    }

    public String readGameCommand() {
        out(InputMessage.INPUT_GAME_COMMAND);
        String input = Console.readLine();
        return input;
    }

    private void out(String text) {
        System.out.println(text);
    }

    private void blank() {
        System.out.println();
    }
}
