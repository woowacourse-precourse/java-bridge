package bridge.Utils;

import static bridge.Enums.ErrorMessage.*;
import static bridge.Enums.View.*;

public class Validation {

    private final int MIN_BRIDGE_LENGTH = 3;
    private final int MAX_BRIDGE_LENGTH = 20;

    public int checkSizeReturnInt(String size) {
        int parsedSize;

        try {
            parsedSize = Integer.parseInt(size);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(ONLY_NUMBER_ALLOWED.getMessage());
        }

        return checkRangeOfSizeReturnInt(parsedSize);
    }

    public int checkRangeOfSizeReturnInt(int size) {
        if (MIN_BRIDGE_LENGTH > size || size > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_BRIDGE_ALLOWED_SIZE.getMessage());
        }

        return size;
    }

    public void checkProperDirection(String direction) {
        if (direction.equals(UPPER_POSITION.toString()) || direction.equals(LOWER_POSITION.toString())) {
            return;
        }
        throw new IllegalArgumentException(ONLY_UD_INPUT_ALLOWED.getMessage());
    }

    public void checkGameCommandInput(String direction) {
        if (direction.equals(RETRY_INPUT.toString()) || direction.equals(QUIT_GAME.toString())) {
            return;
        }
        throw new IllegalArgumentException(ONLY_RQ_INPUT_ALLOWED.getMessage());
    }

}
