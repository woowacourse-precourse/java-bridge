package bridge.model.entity;

import bridge.model.value.PlayerMessage;

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
        throw new IllegalArgumentException("[ERROR] 입력한 값이 조건에 맞지않습니다. U(위), D(아래): 다시 입력해주세요:" + answer);
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
