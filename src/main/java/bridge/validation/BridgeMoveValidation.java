package bridge.validation;

import bridge.message.ErrorMessage;
import java.util.List;

public class BridgeMoveValidation {
    private static final List<String> movePossibilityValue = List.of("U", "D");


    public void bridgeMoveValidation(String data) {
        if (checkMoveInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MOVE_ERROR);
    }


    public boolean checkMoveInputData(String data) {
        return movePossibilityValue.contains(data);
    }


}
