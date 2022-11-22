package bridge.validator;

import static bridge.validator.ErrorConst.*;

public class MoveValidator implements Validator{
    @Override
    public void validate(String move) {
        if (!isOne(move)) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
        if (!isUpDown(move)) {
            throw new IllegalArgumentException(UPDOWN_ERROR);
        }
    }

    private boolean isOne(String command) {
        if (command.length() > COMMANDSIZE) return false;
        return true;
    }

    private boolean isUpDown(String move) {
        if (!move.equals(UP) && !move.equals(DOWN)) return false;
        return true;
    }
}
