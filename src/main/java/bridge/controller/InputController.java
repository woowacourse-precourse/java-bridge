package bridge.controller;

import bridge.model.Direction;
import bridge.util.Constant;
import bridge.util.ExceptionMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getBridgeSize() {
        while (true) {
            try {
                outputView.printEnterSize();
                return checkBridgeSize(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private int convertToNumber(String sizeInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(sizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.CANNOT_CONVERT_TO_NUMBER);
        }
    }

    private void isValidBridgeSize(int size) throws IllegalArgumentException {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    private int checkBridgeSize(String sizeInput) throws IllegalArgumentException {
        int size = convertToNumber(sizeInput);
        isValidBridgeSize(size);
        return size;
    }

    public String getMovingDirection() {
        while (true) {
            try {
                outputView.printInputMoving();
                return checkDirection(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private String checkDirection(String directionInput) throws IllegalArgumentException {
        isValidDirection(directionInput);
        return directionInput;
    }

    private void isValidDirection(String directionInput) throws IllegalArgumentException {
        if (!Direction.isEqualToUp(directionInput) && !Direction.isEqualToDown(directionInput)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.INVALID_DIRECTION);
        }
    }

    public String getGameCommand() {
        while (true) {
            try {
                outputView.printInputGameCommand();
                return checkGameCommand(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private String checkGameCommand(String commandInput) throws IllegalArgumentException {
        isValidGameCommand(commandInput);
        return commandInput;
    }

    private void isValidGameCommand(String commandInput) throws IllegalArgumentException {
        if (!commandInput.equals(Constant.RETRY) && !commandInput.equals(Constant.QUIT)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.INVALID_GAME_COMMAND);
        }
    }
}
