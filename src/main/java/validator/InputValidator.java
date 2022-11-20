package validator;

import static model.BridgeGameExceptions.*;

import java.util.Arrays;
import model.Bridge;
import model.BridgeGameExceptions;
import model.MoveChoice;

public class InputValidator {

    void validateBridgeLength(int bridgeLength) {
        if (Bridge.LOWER_BOUND <= bridgeLength && bridgeLength <= Bridge.UPPER_BOUND) {
            return;
        }
        throw new IllegalArgumentException(OUT_OF_RANGE);
    }

    void validateMoveChoice(String moving) {
        if (Arrays.stream(MoveChoice.values()).anyMatch((choice) -> choice.moving.equals(moving))) {
            return;
        }
        throw new IllegalArgumentException(NOT_A_MOVE_CHOICE);
    }

    void validateRetryIntention(String intention) {
    }
}
