package bridge.domain;

import bridge.utils.validator.MoveValidator;


public class Move {

    private final String move;

    public Move(String move) {
        new MoveValidator(move);
        this.move = move;
    }

    public boolean makeMoveResult(String BridgeStep) {
        if (BridgeStep.equals(this.move)) {
            return true;
        }
        return false;
    }

    public String getMove() {
        return this.move;
    }

}
