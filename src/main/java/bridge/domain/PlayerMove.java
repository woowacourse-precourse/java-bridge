package bridge.domain;

import static bridge.domain.Move.*;
import static bridge.domain.MoveResult.*;

import bridge.common.ErrorMessage;
import java.util.Arrays;

public enum PlayerMove {
    UP_SUCCESS(UP, SUCCESS),
    DOWN_SUCCESS(DOWN, SUCCESS),
    UP_FAIL(UP, FAIL),
    DOWN_FAIL(DOWN, FAIL);

    private final Move move;
    private final MoveResult moveResult;

    PlayerMove(Move move, MoveResult moveResult) {
        this.move = move;
        this.moveResult = moveResult;
    }

    public static PlayerMove of(Move move, MoveResult moveResult) {
        return Arrays.stream(PlayerMove.values())
                .filter(playerMove -> playerMove.move == move && playerMove.moveResult == moveResult)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.isInvalidGameStatus()));
    }

    public boolean isNotSameMove(Move move) {
        return this.move.isNotSameMove(move);
    }

    public boolean isFail() {
        return moveResult.isFail();
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
