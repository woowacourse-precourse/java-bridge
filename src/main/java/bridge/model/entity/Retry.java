package bridge.model.entity;

import bridge.model.value.ErrorMessage;
import bridge.model.value.PlayerMessage;

import static bridge.model.value.ErrorMessage.*;
import static bridge.model.value.PlayerMessage.QUIT;
import static bridge.model.value.PlayerMessage.RETRY;

public class Retry {
    private final String answer;

    private Retry(String answer) {
        validate(answer);
        this.answer = answer;
    }

    private void validate(String answer) {
        if (isMatchMessage(answer)) return;
        throw new IllegalArgumentException(getMessage(RETRY_ERROR));
    }

    private static boolean isMatchMessage(String answer) {
        if(QUIT.equals(answer) || RETRY.equals(answer)){
            return true;
        }
        return false;
    }

    public String getAnswer() {
        return this.answer;
    }

    public static Retry of(String answer) {
        return new Retry(answer);
    }


}
