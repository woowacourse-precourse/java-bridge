package bridge.model.entity;

import bridge.model.value.PlayerMessage;

import java.util.List;

import static bridge.model.value.ErrorMessage.RETRY_ERROR;
import static bridge.model.value.ErrorMessage.getMessage;
import static bridge.model.value.PlayerMessage.QUIT;
import static bridge.model.value.PlayerMessage.RETRY;

public class Player {

    private String answer;

    private Player() {
        this.answer = "R";
    }

    public void setAnswer(String answer) {
        validate(answer);
        this.answer = answer;
    }
    public String getAnswer(){
        return this.answer;
    }

    private void validate(String answer){
        if(!QUIT.equals(answer) && !RETRY.equals(answer)){
            throw new IllegalArgumentException(getMessage(RETRY_ERROR));
        }
    }

    public static Player of(){
        return new Player();
    }

}
