package bridge.domain;

import static bridge.view.SystemMessage.ERROR_MESSAGE;
import static bridge.view.SystemMessage.MOVING_CAMMAND_ERROR_MESSAGE;

public class MoveSpace {

    private final String move;

    public MoveSpace(String move) {
        validateMoving(move);
        this.move = move;
    }

    private static void validateMoving(String moving_space) {
        if (!moving_space.equals("U") && !moving_space.equals("D")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + MOVING_CAMMAND_ERROR_MESSAGE);
        }
    }


    public boolean isItMovable(String step) {
        if (step.equals(this.move)) {
            return true;
        }
        return false;
    }

    public String getMove() {
        return this.move;
    }

}
