package bridge.view;

import bridge.view.stringenum.PrintMessage;
import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        printMessage(PrintMessage.BRIDGE_LENGTH.print());
        return readNumber(Console.readLine());
    }

    public String readMoving() {
        printMessage(PrintMessage.MOVE.print());
        return readString(Console.readLine());
    }

    public String readGameCommand() {
        printMessage(PrintMessage.RESTART.print());
        return readString(Console.readLine());
    }

    private int readNumber(String input) throws IllegalArgumentException {
        InputValidator.validateNumber(input);
        return Integer.parseInt(input);
    }

    private String readString(String input) throws IllegalArgumentException {
        InputValidator.validateOnlyString(input);
        return input;
    }

    private void printMessage(String requestMessage) {
        System.out.println(requestMessage);
    }

}
