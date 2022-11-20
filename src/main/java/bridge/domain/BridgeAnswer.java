package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeGameState.*;

public class BridgeAnswer {

    private final List<BridgeMoveType> bridgeAnswer;

    public BridgeAnswer(List<BridgeMoveType> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public void setUpAnswerSizeBy(int bridgeSize) {
        clearBridgeAnswer();
        setUpBridgeAnswer(bridgeSize);
    }

    public BridgeGameState compareWith(BridgePlayer bridgePlayer) {
        if (bridgePlayer.isNotSameLocation(bridgeAnswer)) {
            return LOSE;
        }
        if (bridgePlayer.isPlayerReached(bridgeAnswer)) {
            return WIN;
        }
        return CONTINUE;
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

    public List<BridgeMoveType> getAnswerMoveHistory() {
        return new ArrayList<>(bridgeAnswer);
    }
}
