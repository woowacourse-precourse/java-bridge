package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final int MIN_BRIDGE_LENGTH = 3;
    private final int MAX_BRIDGE_LENGTH = 20;

    public int readBridgeSize() {
        try {
            int number = convertStringToInt(readInput());
            validateSize(number);
            return number;
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            String command = readInput();
            InputType.validateMovingCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String command = readInput();
            InputType.validateContinuousCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }

    private void validateSize(int size) {
        if (size < MIN_BRIDGE_LENGTH || size > MAX_BRIDGE_LENGTH)
            Error.printException(ErrorType.RANGE);
    }

    private int convertStringToInt(String input) {
        InputType.validateNumber(input);
        return Integer.parseInt(input);
    }

    private String readInput() {
        return Console.readLine();
    }
}
