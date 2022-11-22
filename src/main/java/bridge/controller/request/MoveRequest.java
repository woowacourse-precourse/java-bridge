package bridge.controller.request;

import static bridge.domain.enums.Move.D;
import static bridge.domain.enums.Move.U;

import bridge.domain.enums.Move;

public class MoveRequest {

    private final Move move;

    public MoveRequest(String move) {
        validate(move);
        this.move = Move.valueOf(move);
    }

    private void validate(String move) {
        if (!isValid(move)) {
            throw new IllegalArgumentException("이동시 입력값은 U, D 만 가능합니다.");
        }
    }

    private boolean isValid(String move) {
        return move.equals(U.name()) || move.equals(D.name());
    }

    public Move getMove() {
        return move;
    }
}
