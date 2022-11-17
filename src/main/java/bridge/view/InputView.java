package bridge.view;

import bridge.constant.Constant;
import bridge.constant.ExceptionMessage;
import bridge.constant.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.print(PrintMessage.INPUT_BRIDGE_SIZE.getString());
        String inputBridgeSize = Console.readLine();
        try {
            validateBridgeSize(inputBridgeSize);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readBridgeSize();
        }
        return Integer.parseInt(inputBridgeSize);
    }

    public String readMoving() {
        System.out.print(PrintMessage.INPUT_MOVING.getString());
        String inputMoving = Console.readLine();
        if (validateMoving(inputMoving) == false) {
            return readMoving();
        }
        return inputMoving;
    }

    public String readGameCommand() {
        System.out.print(PrintMessage.INPUT_GAME_COMMAND.getString());
        String inputGameCommand = Console.readLine();
        if (validateMoving(inputGameCommand) == false) {
            return readGameCommand();
        }
        return inputGameCommand;
    }

    private void validateBridgeSize(String inputBridgeSize) throws IllegalArgumentException {
        try {
            int size = Integer.parseInt(inputBridgeSize);
            if (size < Constant.BRIDGE_MIN_SIZE.getValue() || size > Constant.BRIDGE_MAX_SIZE.getValue()) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE.getString());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE_TYPE.getString());
        }
    }

    private boolean validateMoving(String Moving) {
        return true;
    }

    private boolean validateGameCommand(String gameCommand) {
        return true;
    }
}
