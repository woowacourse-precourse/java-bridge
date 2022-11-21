package bridge.view;

import bridge.constant.Constant;
import bridge.constant.ExceptionMessage;
import bridge.constant.GameCommand;
import bridge.constant.Moving;
import bridge.constant.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String getInput(PrintMessage printMessage) {
        System.out.print(printMessage.getString());
        return Console.readLine();
    }

    public int readBridgeSize() {
        String inputBridgeSize = getInput(PrintMessage.INPUT_BRIDGE_SIZE);
        try {
            validateBridgeSize(inputBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(inputBridgeSize);
    }

    public String readMoving() {
        String inputMoving = getInput(PrintMessage.INPUT_MOVING);
        try {
            validateMoving(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return inputMoving;
    }

    public String readGameCommand() {
        String inputGameCommand = getInput(PrintMessage.INPUT_GAME_COMMAND);
        try {
            validateGameCommand(inputGameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return inputGameCommand;
    }

    private void validateBridgeSize(String inputBridgeSize) {
        validateBridgeSizeType(inputBridgeSize);
        int size = Integer.parseInt(inputBridgeSize);
        validateBridgeSizeRange(size);
    }

    private void validateBridgeSizeType(String inputBridgeSize) {
        try {
            Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE_TYPE.getString());
        }
    }

    private void validateBridgeSizeRange(int size) {
        if (size < Constant.BRIDGE_MIN_SIZE.getValue() || size > Constant.BRIDGE_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE.getString());
        }
    }


    private void validateMoving(String moving) {
        try {
            Moving.valueOf(moving);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MOVING.getString());
        }
    }

    private void validateGameCommand(String gameCommand) {
        try {
            GameCommand.valueOf(gameCommand);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getString());
        }
    }
}
