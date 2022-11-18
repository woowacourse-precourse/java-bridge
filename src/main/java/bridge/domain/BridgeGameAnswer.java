package bridge.domain;

import java.util.List;

public class BridgeGameAnswer {

    private final List<String> bridgeAnswer;

    public BridgeGameAnswer(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public boolean isAnswer(String answer, int index) {
        if (bridgeAnswer.get(index) == answer) {
            return true;
        }
        return false;
    }
}
