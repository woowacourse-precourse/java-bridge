package bridge.validation;

import bridge.convertor.InputConvertor;
import bridge.game.Player;
import bridge.resource.ErrorMessage;
import bridge.resource.GameConstant;
import bridge.view.OutputView;

public class BridgeSizeValidator {

    public String sizeValidator(String input) {
        try {
            bridgeSizeValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return Player.requestInputSizeToValidation();
        }
    }

    private void bridgeSizeValidation(String value) {
        if (checkBridgeSize(convertInputToNumber(value))) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR);
    }

    private int convertInputToNumber(String value) {
        try {
            return InputConvertor.inputParseNumber(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NO_NUMBER_ERROR);
        }
    }

    private boolean checkBridgeSize(int size) {
        return GameConstant.BRIDGE_MIN_SIZE <= size && size <= GameConstant.BRIDGE_MAX_SIZE;
    }
}
