package view;

import constant.ErrorMessage;
import constant.GameConstant;
import constant.StringConstant;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public int readBridgeSize() throws IllegalArgumentException {
        String size = Console.readLine();
        isValidBridgeSize(size);
        return Integer.parseInt(size);
    }

    public String readMoving() throws IllegalArgumentException {
        String moving = Console.readLine();
        isValidMove(moving);
        return moving;
    }

    public String readGameCommand() throws IllegalArgumentException {
        String gameCommand = Console.readLine();
        isValidRetryOrQuit(gameCommand);
        return gameCommand;
    }

    public int convertStringToInt(String size) {
        return Integer.parseInt(size);
    }
    
    public void isValidBridgeSize(String size) throws IllegalArgumentException {
        isBridgeSizeComponentNumber(size);
        isValidBridgeSizeRange(convertStringToInt(size));
    }

    public void isBridgeSizeComponentNumber(String size) {
        if (!size.matches(StringConstant.BRIDGE_SIZE_REGEX.getConstant())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NOT_NUMBER.getErrorMessage());
        }
    }

    public void isValidBridgeSizeRange(int size) {
        if (GameConstant.BRIDGE_SIZE_START_INCLUSIVE.getConstant() > size
                || size > GameConstant.BRIDGE_SIZE_END_INCLUSIVE.getConstant()) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INVALID_RANGE.getErrorMessage());
        }
    }

    public void isValidMove(String moving) {
        if (!moving.equals(StringConstant.UP_SIDE.getConstant())
                && !moving.equals(StringConstant.DOWN_SIDE.getConstant())) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_INVALID.getErrorMessage());
        }
    }

    public void isValidRetryOrQuit(String gameCommand) {
        if (!gameCommand.equals(StringConstant.QUIT.getConstant())
                && !gameCommand.equals(StringConstant.RETRY.getConstant())) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_OR_QUIT_INVALID.getErrorMessage());
        }
    }
}
