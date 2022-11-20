package bridge.view;

import static bridge.constant.ErrorConstant.ENTER_BRIDGE_LENGTH;
import static bridge.constant.ErrorConstant.PICK_COMMAND;
import static bridge.constant.ErrorConstant.PICK_POSITION;
import static bridge.type.MovingType.DOWN;
import static bridge.type.MovingType.UP;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.type.ErrorType;

public class InputView {
    private static final String REGEX = "[0-9]+";

    public int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_LENGTH);
        return validateDigit(readLine());
    }

    public String readMoving() {
        System.out.println(PICK_POSITION);
        String moving = readLine();
        try {
            validateMoving(moving);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
        return moving;
    }

    public String readGameCommand() {
        System.out.println(PICK_COMMAND);
        String command = readLine();
        try {
            validateRetryOrExit(command);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
        return command;
    }

    private int validateDigit(String input) throws IllegalArgumentException {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorType.DIGIT_ERROR.printError());
        }
        return Integer.parseInt(input);
    }

    private void validateMoving(String input) {
        if (!input.equals(UP.getKey()) && !input.equals(DOWN.getKey())) {
            throw new IllegalArgumentException(ErrorType.MOVING_ERROR.printError());
        }
    }

    private void validateRetryOrExit(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ErrorType.COMMAND_ERROR.printError());
        }
    }
}
