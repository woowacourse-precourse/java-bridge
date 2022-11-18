package bridge.model.entity;

import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> answer;

    public Bridge(int size) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> answer = maker.makeBridge(size);
        validate(answer);
        this.answer = answer;
    }

    private void validate(List<String> answer) {
        //TODO: 예외 조건 추가하기
    }

    public List<String> getAnswer() {
        return this.answer;
    }

}
