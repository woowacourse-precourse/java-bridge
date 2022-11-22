package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> answerBridge;

    public Bridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public List<String> getAnswerBridge() {
        return answerBridge;
    }
}
