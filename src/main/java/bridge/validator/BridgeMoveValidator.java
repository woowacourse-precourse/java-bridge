package bridge.validator;

import bridge.resource.ErrorMessage;
import bridge.resource.GameConstant;
import java.util.List;

public class BridgeMoveValidator {
    private static final List<String> movePossibilityValue = List.of(GameConstant.TOP, GameConstant.BOTTOM);

    public String moveValidator(String input) throws IllegalArgumentException {
        bridgeMoveValidation(input);
        return input;
    }

    private void bridgeMoveValidation(String data) {
        if (checkMoveInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MOVE_ERROR);
    }


    private boolean checkMoveInputData(String data) {
        return movePossibilityValue.contains(data);
    }


}
