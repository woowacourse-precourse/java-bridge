package bridge.view;

import bridge.message.ExceptionMessage;
import bridge.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        out(InputMessage.START_GAME);
        blank();
        out(InputMessage.INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        blank();
        stringType(input);
        return Integer.parseInt(input);
    }

    private void stringType(String bonus) {
        int eachChar = String.valueOf(bonus).charAt(0);
        if (!Character.isDigit(eachChar)) {
            out(ExceptionMessage.NOT_INTEGER);
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER);
        }
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
