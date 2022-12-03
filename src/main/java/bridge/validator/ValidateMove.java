package bridge.validator;

import static bridge.util.BridgeConstant.DOWN_KEY;
import static bridge.util.BridgeConstant.UP_KEY;

public class ValidateMove implements Validator {
    private final String INPUT_MOVE_ERROR_MESSAGE = "이동 값으로는 `U` 혹은 `D`를 입력해야합니다.";

    @Override
    public void validate(String readInput) {
        if (!validateMoveRange(readInput)) {
            throw new IllegalArgumentException(INPUT_MOVE_ERROR_MESSAGE);
        }
    }

    private boolean validateMoveRange(String readBridgeMove) {
        return readBridgeMove.equals(DOWN_KEY) || readBridgeMove.equals(UP_KEY);
    }
}
