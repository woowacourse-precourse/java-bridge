package bridge.domain;

import static bridge.domain.Direction.DOWN;
import static bridge.domain.Direction.UP;
import static bridge.domain.MoveResult.FAIL;
import static bridge.domain.MoveResult.SUCCESS;

import java.util.Arrays;

public enum PlayerMove {
    UP_SUCCESS(UP, SUCCESS),
    UP_FAIL(UP, FAIL),
    DOWN_SUCCESS(DOWN, SUCCESS),
    DOWN_FAIL(DOWN, FAIL);

    private static final String INVALID_PLAYER_MOVE_MESSAGE = "올바른 방향과 결과를 입력해주세요.";

    private final Direction direction;
    private final MoveResult moveResult;

    PlayerMove(Direction direction, MoveResult moveResult) {
        this.direction = direction;
        this.moveResult = moveResult;
    }

    public static PlayerMove getEnum(Direction direction, MoveResult moveResult) {
        return Arrays.stream(PlayerMove.values())
                .filter(playerMove -> playerMove.direction == direction)
                .filter(playerMove -> playerMove.moveResult == moveResult)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_MOVE_MESSAGE));
    }

    public boolean isNotSameDirection(Direction direction) {
        return this.direction.isNotSameDirection(direction);
    }

    public boolean isFail() {
        return moveResult.isFail();
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
