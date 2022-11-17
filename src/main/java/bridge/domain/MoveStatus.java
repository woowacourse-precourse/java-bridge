package bridge.domain;

import bridge.utils.Constants;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MoveStatus {
    UP(Constants.UP, Constants.COLLECT_MESSAGE),
    DOWN(Constants.DOWN, Constants.COLLECT_MESSAGE),
    UP_FAIL(Constants.UP_AND_FAIL, Constants.FAIL_MESSAGE),
    DOWN_FAIL(Constants.DOWN_AND_FAIL, Constants.FAIL_MESSAGE);

    private static final Map<String, MoveStatus> BY_SPACE_TO_MOVE = Arrays.stream(values())
            .collect(Collectors.toMap(moveStatus -> moveStatus.spaceToMove, moveStatus -> moveStatus));

    private final String spaceToMove;
    private final String moveMessage;

    MoveStatus(String spaceToMove, String moveMessage) {
        this.spaceToMove = spaceToMove;
        this.moveMessage = moveMessage;
    }

    public static MoveStatus findBySpaceToMove(String spaceToMove, boolean canGo) {
        if (canGo) {
            return BY_SPACE_TO_MOVE.get(spaceToMove);
        }
        return findFail(spaceToMove);
    }

    private static MoveStatus findFail(String spaceToMove) {
        if (spaceToMove.equals(Constants.UP)) {
            return UP_FAIL;
        }
        return DOWN_FAIL;
    }

    public String isUp() {
        if (this == UP || this == UP_FAIL) {
            return this.moveMessage;
        }
        return Constants.BLANK;
    }

    public String isDown() {
        if (this == DOWN || this == DOWN_FAIL) {
            return this.moveMessage;
        }
        return Constants.BLANK;
    }
}
