package bridge.valid;

import bridge.valid.InputValidator;

import java.util.List;

public class MovingValidator implements InputValidator {

    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String MOVING_INPUT_ERROR_MESSAGE = "[ERROR] U(위), D(아래) 중 하나를 입력해야 합니다.";

    @Override
    public void validateInput(String input) throws IllegalArgumentException {
        List<String> movingOptions = List.of(UP_BRIDGE, DOWN_BRIDGE);
        if(!movingOptions.contains(input)) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
    }
}
