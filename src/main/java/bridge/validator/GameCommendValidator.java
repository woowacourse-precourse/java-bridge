package bridge.validator;

import bridge.ErrorMessage;
import bridge.GameCommend;

public class GameCommendValidator {

    private final GameCommend commend;

    public GameCommendValidator(final String input) {
        validate(input);
        this.commend = GameCommend.of(input);
    }

    private void validate(final String input) {
        if (!isValidType(input)) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_GAME_COMMEND
            );
        }
    }

    private boolean isValidType(final String input) {
        return GameCommend.contains(input);
    }

    public GameCommend getCommend() {
        return commend;
    }
}
