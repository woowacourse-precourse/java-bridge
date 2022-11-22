package utils;

import static constant.ErrorMessage.*;
import org.assertj.core.util.Strings;

public class Validation {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 20;

    public Validation() {

    }

    public String validMovingNext(String movingNext) throws IllegalArgumentException {
        try {
            return validUOrD(movingNext);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(ASK_INPUT_VALUE, ERROR_HEAD_MESSAGE));
        }
    }

    public String validUOrD(String movingNext) throws IllegalArgumentException {
        if (!(movingNext.equals("U") || movingNext.equals("D"))) {
            throw new IllegalArgumentException(String.format(ASK_INPUT_CHARACTER_U_OR_D, ERROR_HEAD_MESSAGE));
        }
        return movingNext;
    }

    public int validBridgeSize(String bridgeSize) throws IllegalArgumentException {
        try {
            return validBridgeLengthRange(Long.parseLong(bridgeSize));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ASK_INPUT_NUMBER, ERROR_HEAD_MESSAGE));
        }
    }

    private int validBridgeLengthRange(long bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < MINIMUM_LENGTH || bridgeSize > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format(WRONG_LENGTH, ERROR_HEAD_MESSAGE));
        }
        return (int) bridgeSize;
    }

    public void validGameCommand(String gameCommand) throws IllegalArgumentException {
        try {
            if (Strings.isNullOrEmpty(gameCommand)) {
                throw new NullPointerException(String.format(ASK_INPUT_VALUE, ERROR_HEAD_MESSAGE));
            }
            validIsRegameOrQuitCharacter(gameCommand);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validIsRegameOrQuitCharacter(String gameCommand) throws IllegalArgumentException {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException(String.format(ASK_INPUT_CHARACTER_R_OR_Q, ERROR_HEAD_MESSAGE));
        }
    }
}
