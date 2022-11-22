package bridge.view;

import bridge.resource.InputType;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        try {
            return convertStringToInt(readInput());
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }

    public static String readMoving() {
        try {
            String command = readInput();
            InputType.validateMovingCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    public static String readGameCommand() {
        try {
            String command = readInput();
            InputType.validateContinuousCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }

    private static int convertStringToInt(String input) {
        InputType.validateNumber(input);
        return Integer.parseInt(input);
    }

    private static String readInput() {
        return Console.readLine();
    }
}
