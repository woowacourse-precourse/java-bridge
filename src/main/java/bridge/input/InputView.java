package bridge.input;

import camp.nextstep.edu.missionutils.Console;

import static bridge.input.InputString.*;

public class InputView {
    public static int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT);
        String input = Console.readLine();
        try {
            int inputLength = Integer.parseInt(input);
            if (inputLength < 3 || inputLength > 20) {
                throw new IllegalArgumentException(ERROR_NOT_IN_RANGE);
            }
            return inputLength;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NO_NUMBER_INPUT);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readBridgeSize();
    }

    public static String readMoving() {
        String input = getCommandInput(MOVE_INPUT, UP, DOWN, ERROR_MOVE_INPUT);
        if (input != null) return input;
        return readMoving();
    }

    public static String readGameCommand() {
        String input = getCommandInput(RETRY_INPUT, RESTART, QUIT, ERROR_RESTART_INPUT);
        if (input != null) return input;
        return readGameCommand();
    }

    private static String getCommandInput(String printInput, String command1, String command2, String errorName) {
        System.out.println(printInput);
        String input = Console.readLine();
        try {
            if (!input.equals(command1) && !input.equals(command2)) {
                throw new IllegalArgumentException(errorName);
            }
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
