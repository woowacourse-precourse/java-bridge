package bridge.view;

import bridge.message.ExceptionMessage;
import bridge.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        out(InputMessage.START_GAME);
        blank();
        out(InputMessage.INPUT_BRIDGE_SIZE);
        int inputNum = validate();
        blank();
        return inputNum;
    }

    private int validate() {
        int inputNum = 0;
        while (true) {
            String input = Console.readLine();
            try {
                inputNum = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                out(ExceptionMessage.NOT_INTEGER);
            }
        }
        return inputNum;
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
