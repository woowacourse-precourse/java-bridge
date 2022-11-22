package bridge.domain.vo;

import static bridge.enumeration.ErrorMessage.*;
import static bridge.enumeration.Command.*;

public class Moving {

    private final String moving;
    private final int MOVING_MAX_LENGTH = 1;

    public static Moving recordMoving(String moving) {
        return new Moving(moving);
    }

    private Moving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    public String getMoving() {
        return this.moving;
    }

    private void validateMoving(String moving) {
        if (moving.length() != MOVING_MAX_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
        if (!moving.equals(UP.getCommand()) && !moving.equals(DOWN.getCommand())) {
            throw new IllegalArgumentException(INVALID_MOVE.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Moving other = (Moving) obj;
        return this.getMoving().equals(other.getMoving());
    }
}
