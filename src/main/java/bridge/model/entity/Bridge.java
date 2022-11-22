package bridge.model.entity;

import bridge.model.value.ErrorMessage;

import java.util.List;

import static bridge.model.value.ErrorMessage.*;
import static bridge.model.value.PlayerMessage.DOWN;
import static bridge.model.value.PlayerMessage.UP;

public class Bridge {
    private final List<String> answer;

    private Bridge(List<String> answer) {
        validate(answer);
        this.answer = answer;
    }

    private void validate(List<String> answer) {
        for(int i = 0; i < answer.size(); i++) {
            if(!answer.get(i).equals(UP) && !answer.get(i).equals(DOWN)){
                throw new IllegalArgumentException(getMessage(BRIDGE_ERROR));
            }
        }
    }

    public List<String> getAnswer() {
        return this.answer;
    }

    public static Bridge of(List<String> answer){
        return new Bridge(answer);
    }

}
