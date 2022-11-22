package bridge.util;

import static bridge.enums.BridgeStatus.LOWER;
import static bridge.enums.BridgeStatus.UPPER;
import static bridge.enums.ExceptionMessage.*;
import static bridge.enums.GameCommand.QUIT;
import static bridge.enums.GameCommand.RETRY;

public class GameInputValidator {

    private final Integer LIMITED_MIN_NUMBER = 3;
    private final Integer LIMITED_MAX_NUMBER = 20;

    public int parseNumber(String number) {
        try {
            int size = Integer.parseInt(number);
            if (isRangedNumber(size)) {
                return size;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
        }
        throw new IllegalArgumentException(IS_NOT_RANGED_NUMBER.getMessage());
    }

    public String isValidMovingMessage(String moving) {
        if (moving.equals(UPPER.getStatus())) {
            return moving;
        }
        if (moving.equals(LOWER.getStatus())) {
            return moving;
        }
        throw new IllegalArgumentException(IS_NOT_VALID_GAME_COMMAND.getMessage());
    }

    public String isValidRetryMessage(String retry) {
        if (retry.equals(RETRY.getCommand())) {
            return retry;
        }
        if (retry.equals(QUIT.getCommand())) {
            return retry;
        }
        throw new IllegalArgumentException(IS_NOT_VALID_RETRY_MESSAGE.getMessage());
    }

    boolean isRangedNumber(int number) {
        return LIMITED_MIN_NUMBER <= number && number <= LIMITED_MAX_NUMBER;
    }
}
