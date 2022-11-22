package bridge.model;

import static bridge.message.ErrorMessage.NOT_A_MOVE_CHOICE;
import static bridge.message.ErrorMessage.NOT_A_RETRY_INTENTION;
import static bridge.message.ErrorMessage.OUT_OF_RANGE;

import bridge.model.constant.MoveDirection;
import bridge.model.constant.RetryIntention;
import java.util.Arrays;

public class InputValidator {

    public void validateBridgeLength(int bridgeLength) {
        if (BridgeGame.MINIMUM_BRIDGE_SIZE <= bridgeLength && bridgeLength <= BridgeGame.MAXIMUM_BRIDGE_SIZE) {
            return;
        }
        throw new IllegalArgumentException(OUT_OF_RANGE.getValue());
    }

    public void validateMoveChoice(String moving) {
        if (Arrays.stream(MoveDirection.values()).anyMatch((choice) -> choice.getDirectionString().equals(moving))) {
            return;
        }
        throw new IllegalArgumentException(NOT_A_MOVE_CHOICE.getValue());
    }

    public void validateRetryIntention(String userIntention) {
        if (Arrays.stream(RetryIntention.values()).anyMatch((intention) -> intention.intention.equals(userIntention))) {
            return;
        }

        throw new IllegalArgumentException(NOT_A_RETRY_INTENTION.getValue());
    }
}
