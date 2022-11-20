package validator;

import static model.BridgeGameExceptions.NOT_A_MOVE_CHOICE;
import static model.BridgeGameExceptions.NOT_A_RETRY_INTENTION;
import static model.BridgeGameExceptions.OUT_OF_RANGE;

import java.util.Arrays;
import model.Bridge;
import model.MoveChoice;
import model.RetryIntention;

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

    void validateRetryIntention(String userIntention) {
        if (Arrays.stream(RetryIntention.values()).anyMatch((intention) -> intention.intention.equals(userIntention))) {
            return;
        }

        throw new IllegalArgumentException(NOT_A_RETRY_INTENTION);
    }
}
