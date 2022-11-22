package bridge.validation;

import java.util.List;

import static bridge.validation.ErrorMessage.*;

public class BridgeGameValidation {
    private static final String UNEXPECTED_WHEN_EQUAL = "X";
    private static final String UNEXPECTED_WHEN_UNEQUAL = "O";

    public void validateMoveWhenAvailable(String movingCommand, String currBox, List<String> bridgeCurrStatus) {
        if (movingCommand.equals(currBox)) {
            int lastIdx = bridgeCurrStatus.size() - 1;

            if (bridgeCurrStatus.get(lastIdx).equals(UNEXPECTED_WHEN_EQUAL)) {
                throw new IllegalArgumentException(MOVE_AVAILABLE_BUT_NOT_MOVED.getMessage());
            }
        }
    }

    public void validateNotMoveWhenUnavailable(String movingCommand, String currBox, List<String> bridgeCurrStatus) {
        if (! movingCommand.equals(currBox)) {
            int lastIdx = bridgeCurrStatus.size() - 1;

            if (bridgeCurrStatus.get(lastIdx).equals(UNEXPECTED_WHEN_UNEQUAL)) {
                throw new IllegalArgumentException(MOVED_WHEN_UNAVAILABLE.getMessage());
            }
        }
    }
}
