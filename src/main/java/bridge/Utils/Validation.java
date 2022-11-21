package bridge.Utils;

import static bridge.Enums.ErrorMessage.*;

public class Validation {

    public int checkSizeReturnInt(String size) {
        int parsedSize;

        try {
            parsedSize = Integer.parseInt(size);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(ONLY_NUMBER_ALLOWED.getMessage());
        }

        if (3 > parsedSize || parsedSize > 20) {
            throw new IllegalArgumentException(OUT_OF_BRIDGE_ALLOWED_SIZE.getMessage());
        }

        return parsedSize;
    }

    public void checkProperDirection(String direction) {
        if (direction.equals("U") || direction.equals("D")) {
            return;
        }

        throw new IllegalArgumentException(ONLY_UD_INPUT_ALLOWED.getMessage());
    }

    public void checkGameCommandInput(String direction) {
        if (direction.equals("R") || direction.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(ONLY_RQ_INPUT_ALLOWED.getMessage());
    }

}
