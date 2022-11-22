package bridge.domain;

import bridge.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class PlayerMovement {
    private static final String UPPER_CHECK = "U";
    private static final String LOWER_CHECK = "D";
    private final List<String> movement;

    public PlayerMovement() {
        movement = new ArrayList<>();
    }

    public List<String> getMovement() {
        return movement;
    }

    public int getMovementCount() {
        return movement.size();
    }

    public void addMovement(String move) {
        validate(move);
        movement.add(move);
    }

    private void validate(String move) {
        if (!move.equals(UPPER_CHECK) && !move.equals(LOWER_CHECK)) {
            ExceptionMessage.INPUT_WRONG_BRIDGE_MOVEMENT_MESSAGE.throwException();
        }
    }
}
