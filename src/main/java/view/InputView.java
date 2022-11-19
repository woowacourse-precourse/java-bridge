package view;

import camp.nextstep.edu.missionutils.Console;
import constants.BridgeConstants;
import constants.Message;

import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern DIGIT_REGEX = Pattern.compile("[0-9]+");

    public int readBridgeSize() {
        try {
            String userInput = Console.readLine();

            validateBridgeSize(userInput);

            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readBridgeSize();
        }
    }

    private void validateBridgeSize(String userInput) {
        validateExistsString(userInput);
        validateBridgeSizeRange(Integer.parseInt(userInput));
    }

    private void validateExistsString(String userInput) {
        if (!userInput.matches(DIGIT_REGEX.pattern())) {
            throw new IllegalArgumentException(Message.INPUT_PATTERN_ERROR_MESSAGE);
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < BridgeConstants.MIN_BRIDGE_SIZE
                || bridgeSize > BridgeConstants.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Message.BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }

    public String readMoving() {
        try {
            String userInput = Console.readLine();

            validateMoving(userInput);

            return userInput;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readMoving();
        }
    }

    private void validateMoving(String userInput) {
        List<String> directions = List.of(
                BridgeConstants.UP_DIRECTION, BridgeConstants.DOWN_DIRECTION);
        if (!directions.contains(userInput)) {
            throw new IllegalArgumentException(Message.MOVING_ERROR_MESSAGE);
        }
    }

    public String readGameCommand() {
        try {
            String userInput = Console.readLine();

            validateGameCommand(userInput);

            return userInput;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readGameCommand();
        }
    }

    private void validateGameCommand(String userInput) {
        List<String> commands = List.of(
                BridgeConstants.RESTART, BridgeConstants.QUIT);

        if (!commands.contains(userInput)) {
            throw new IllegalArgumentException(Message.COMMAND_ERROR_MESSAGE);
        }
    }
}
