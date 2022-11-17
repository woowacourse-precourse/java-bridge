package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;

    public static int readBridgeSize() {
        try {
            int number = convertStringToInt(readInput());
            validateSize(number);
            return number;
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

    private static void validateSize(int size) {
        if (size < MIN_BRIDGE_LENGTH || size > MAX_BRIDGE_LENGTH)
            Error.printException(ErrorType.RANGE);
    }

    private static int convertStringToInt(String input) {
        InputType.validateNumber(input);
        return Integer.parseInt(input);
    }

    private static String readInput() {
        return Console.readLine();
    }
}
