package bridge.util.validator;

import static bridge.util.constants.GameCommand.RETRY;
import static bridge.util.constants.GameCommand.QUIT;

public class GameCommandValidator {
    public static void validate(String input) {
        if (!input.equals(RETRY.command()) && !input.equals(QUIT.command())) {
            throw new IllegalArgumentException("[ERROR] R이나 Q만 입력해야 합니다");
        }
    }
}
