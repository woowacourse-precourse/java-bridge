package bridge.model;

import static bridge.message.ErrorMessage.NOT_A_MOVE_CHOICE;
import static bridge.message.ErrorMessage.NOT_A_RETRY_INTENTION;
import static bridge.message.ErrorMessage.OUT_OF_RANGE;

import bridge.model.enums.MoveChoice;
import bridge.model.enums.RetryIntention;
import java.util.Arrays;

public class InputValidator {

    public void validateBridgeLength(int bridgeLength) {
        if (BridgeGame.MINIMUM_BRIDGE_SIZE <= bridgeLength && bridgeLength <= BridgeGame.MAXIMUM_BRIDGE_SIZE) {
            return;
        }
        throw new IllegalArgumentException(OUT_OF_RANGE.get());
    }

    public void validateMoveChoice(String moving) {
        if (Arrays.stream(MoveChoice.values()).anyMatch((choice) -> choice.moving.equals(moving))) {
            return;
        }
        throw new IllegalArgumentException(NOT_A_MOVE_CHOICE.get());
    }

    public void validateRetryIntention(String userIntention) {
        if (Arrays.stream(RetryIntention.values()).anyMatch((intention) -> intention.intention.equals(userIntention))) {
            return;
        }

        throw new IllegalArgumentException(NOT_A_RETRY_INTENTION.get());
    }
}
