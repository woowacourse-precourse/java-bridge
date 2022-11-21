package bridge.domain;

import java.util.List;

import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.MovableSpace.LOWER_SPACE;
import static bridge.util.constants.ErrorMessage.BRIDGE_INVALID_ERROR;
import static bridge.util.constants.ErrorMessage.BRIDGE_INDEX_ERROR;

public class Bridge {
    private final List<String> movableSpaces;
    public Bridge(List<String> movableSpaces) {
        validate(movableSpaces);
        this.movableSpaces = movableSpaces;
    }

    private void validate(List<String> movableSpaces) {
        for (String space : movableSpaces) {
            if (!space.equals(UPPER_SPACE.getValue()) && !space.equals(LOWER_SPACE.getValue())) {
                throw new IllegalStateException(BRIDGE_INVALID_ERROR.getMessage());
            }
        }
    }

    public int size() {
        return movableSpaces.size();
    }

    private String get(int index) {
        if (index < 1 || size() < index) {
            String errorMessage = String.format(BRIDGE_INDEX_ERROR.getMessage(), index);
            throw new IllegalStateException(errorMessage);
        }
        return movableSpaces.get(index - 1);
    }

    public boolean isBroken(int index, String spaceToMove) {
        if (get(index).equals(spaceToMove)) {
            return false;
        }
        return true;
    }
}
