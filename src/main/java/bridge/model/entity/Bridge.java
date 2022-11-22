package bridge.model.entity;

import bridge.model.value.PlayerMessage;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

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
                throw new IllegalArgumentException("[ERROR] 맵이 정상적으로 생성되지 않았습니다.");
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
