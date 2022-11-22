package bridge;

import bridge.generator.Answer;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int answerNumber = bridgeNumberGenerator.generate();
            Answer answer = Answer.getAnswerByNumber(answerNumber);
            bridge.add(answer.getLetter());
        }
        return bridge;
    }
}
