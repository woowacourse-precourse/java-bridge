package bridge.model.entity;

import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> answer;

    private Bridge(List<String> answer) {
        validate(answer);
        this.answer = answer;
    }

    private void validate(List<String> answer) {
        //TODO: 예외 조건 추가하기
    }

    public List<String> getAnswer() {
        return this.answer;
    }

    public static Bridge of(List<String> answer){
        return new Bridge(answer);
    }

}
