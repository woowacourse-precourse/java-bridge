package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeAnswer {

    private final List<BridgeMoveType> bridgeAnswer;

    public BridgeAnswer(List<BridgeMoveType> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public void setUpAnswerSizeBy(int bridgeSize) {
        clearBridgeAnswer();
        setUpBridgeAnswer(bridgeSize);
    }

    private void clearBridgeAnswer() {
        bridgeAnswer.clear();
    }

    private void setUpBridgeAnswer(int bridgeSize) {
        new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(bridgeSize)
                .stream()
                .map(BridgeMoveType::of)
                .forEach(bridgeAnswer::add);
    }
}
