package bridge.model.valid;

import bridge.model.utils.BridgeSides;

import java.util.List;

public class MovingValidator implements InputValidator {
    private static final String MOVING_INPUT_ERROR_MESSAGE = "[ERROR] U(위), D(아래) 중 하나를 입력해야 합니다.";

    @Override
    public void validateInput(String input) throws IllegalArgumentException {
        List<String> movingOptions = List.of(BridgeSides.UP, BridgeSides.DOWN);
        if(!movingOptions.contains(input)) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
    }
}
