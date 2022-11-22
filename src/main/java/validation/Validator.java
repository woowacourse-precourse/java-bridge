package validation;

import static bridge.constant.ChoiceGame.QUIT;
import static bridge.constant.ChoiceGame.RESTART;
import static bridge.constant.Movement.DOWN;
import static bridge.constant.Movement.UP;
import static bridge.constant.Validation.*;

public class Validator {

    public void validateBridgeLength(String bridgeLength) {
        if (!bridgeLength.matches(PATTERN)) {
            throw new IllegalArgumentException(INPUT_THREE_TO_TWENTY);
        }
        if (Integer.parseInt(bridgeLength) > LAST_LENGTH || Integer.parseInt(bridgeLength) < FIRST_LENGTH) {
            throw new IllegalArgumentException(INPUT_THREE_TO_TWENTY);
        }
    }

    public void validateMovement(String movement) {
        if (!movement.equals(UP.getUpAndDownMovement()) && !movement.equals(DOWN.getUpAndDownMovement())) {
            throw new IllegalArgumentException(INPUT_U_OR_D);
        }
    }

    public void validateRestartOrQuit(String restartOrQuit) {
        if (!restartOrQuit.equals(RESTART) && !restartOrQuit.equals(QUIT)) {
            throw new IllegalArgumentException(INPUT_R_OR_Q);
        }
    }
}
