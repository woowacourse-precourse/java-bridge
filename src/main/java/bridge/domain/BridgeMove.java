package bridge.domain;

import java.util.List;

import static bridge.domain.BridgeMoveJudgment.*;

public enum BridgeMove {

    UPPER_CORRECT(List.of(CORRECT, EMPTY)),
    UPPER_WRONG(List.of(WRONG, EMPTY)),
    LOWER_CORRECT(List.of(EMPTY, CORRECT)),
    LOWER_WRONG(List.of(EMPTY, WRONG));

    private final List<BridgeMoveJudgment> moveJudgments;

    BridgeMove(List<BridgeMoveJudgment> moveJudgments) {
        this.moveJudgments = moveJudgments;
    }

    public List<BridgeMoveJudgment> getMoveJudgments() {
        return moveJudgments;
    }
}
