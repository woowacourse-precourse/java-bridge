package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeGameState.*;
import static bridge.exception.BridgeAnswerExceptionMessage.BRIDGE_ANSWER_EMPTY_EXCEPTION;

public class BridgeAnswer {

    private final List<BridgeMoveType> bridgeAnswer;

    public BridgeAnswer() {
        this.bridgeAnswer = new ArrayList<>();
    }

    public void setUpAnswerSizeBy(int bridgeSize) {
        clearBridgeAnswer();
        setUpBridgeAnswer(bridgeSize);
    }

    public BridgeGameState compareWith(BridgePlayer bridgePlayer) {
        validateBridgeEmpty();
        if (bridgePlayer.isLastMoveTypeNotSameAs(bridgeAnswer)) {
            return FAIL;
        }
        if (bridgePlayer.isAllMoveTypeSameAs(bridgeAnswer)) {
            return SUCCESS;
        }
        return CONTINUE;
    }

    private void validateBridgeEmpty() {
        if (this.bridgeAnswer.isEmpty()) {
            throw new IllegalStateException(BRIDGE_ANSWER_EMPTY_EXCEPTION.getMessage());
        }
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
