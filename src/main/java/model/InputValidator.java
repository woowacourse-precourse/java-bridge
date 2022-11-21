package model;

import static model.BridgeGame.MAXIMUM_BRIDGE_SIZE;
import static model.BridgeGame.MINIMUM_BRIDGE_SIZE;
import static model.BridgeGameExceptions.NOT_A_MOVE_CHOICE;
import static model.BridgeGameExceptions.NOT_A_RETRY_INTENTION;
import static model.BridgeGameExceptions.OUT_OF_RANGE;

import java.util.Arrays;
import model.enums.MoveChoice;
import model.enums.RetryIntention;

public class InputValidator {

    public void validateBridgeLength(int bridgeLength) {
        if (MINIMUM_BRIDGE_SIZE <= bridgeLength && bridgeLength <= MAXIMUM_BRIDGE_SIZE) {
            return;
        }
        throw new IllegalArgumentException(OUT_OF_RANGE);
    }

    public void validateMoveChoice(String moving) {
        if (Arrays.stream(MoveChoice.values()).anyMatch((choice) -> choice.moving.equals(moving))) {
            return;
        }
        throw new IllegalArgumentException(NOT_A_MOVE_CHOICE);
    }

    public void validateRetryIntention(String userIntention) {
        if (Arrays.stream(RetryIntention.values()).anyMatch((intention) -> intention.intention.equals(userIntention))) {
            return;
        }

        throw new IllegalArgumentException(NOT_A_RETRY_INTENTION);
    }
}
