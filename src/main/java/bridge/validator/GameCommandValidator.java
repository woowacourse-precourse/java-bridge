package bridge.validator;

import static bridge.validator.ErrorConst.*;

public class GameCommandValidator implements Validator{
    @Override
    public void validate(String command) {
        if (!isOne(command)) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
        if (!isRetryQuit(command)) {
            throw new IllegalArgumentException(RETRYQUIT_ERROR);
        }
    }
    private boolean isOne(String command) {
        if (command.length() > COMMANDSIZE) return false;
        return true;
    }
    private boolean isRetryQuit(String command) {
        if (!command.equals(RETRY) && !command.equals(QUIT)) return false;
        return true;
    }

}
