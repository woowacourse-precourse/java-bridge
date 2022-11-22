package bridge.service;

import bridge.Constants.ErrorMessageConstant;
import bridge.domain.InputHandler;

public class InputHandlerImpl implements InputHandler {



    @Override
    public int getBridgeSize(String rawInput) {
        String refineInput = removeSpacesFromString(rawInput);
        int size = parseInteger(refineInput);
        validateBridgeLength(size);
        return size;
    }

    @Override
    public String getMovingCommand(String rawInput) {
        String refineCommand = removeSpacesFromString(rawInput);
        validateMoving(refineCommand);
        return refineCommand;
    }

    @Override
    public String getGameCommand(String rawInput) {
        String refineCommand = removeSpacesFromString(rawInput);
        validateGameCommand(refineCommand);
        return refineCommand;
    }

    private int parseInteger(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.NOT_INTEGER);
        }
    }

    private String removeSpacesFromString(String rawInput) {
        return rawInput.replaceAll("\\s+","");
    }

    private void validateBridgeLength(int length) {
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException(ErrorMessageConstant.INVALID_BRIDGE_LENGTH);
        }
    }

    private void validateMoving(String command) {
        if (!command.matches("^[UD]$")) {
            throw new IllegalArgumentException(ErrorMessageConstant.INVALID_MOVING_COMMAND);
        }
    }


    private void validateGameCommand(String command) {
        if (!command.matches("^[RQ]$")) {
            throw new IllegalArgumentException(ErrorMessageConstant.INVALID_GAME_OVER_CONTROL_COMMAND);
        }
    }
}
