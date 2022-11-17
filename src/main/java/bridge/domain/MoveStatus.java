package bridge.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MoveStatus {
    UP("U", "O"),
    DOWN("D", "O"),
    UP_FAIL("UF", "X"),
    DOWN_FAIL("DF", "X");

    private static final Map<String, MoveStatus> BY_SPACE_TO_MOVE = Arrays.stream(values())
            .collect(Collectors.toMap(moveStatus -> moveStatus.spaceToMove, moveStatus -> moveStatus));
    private static final String BLANK = " ";

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
        if (spaceToMove.equals("U")) {
            return UP_FAIL;
        }
        return DOWN_FAIL;
    }

    public String isUp() {
        if (this == UP || this == UP_FAIL) {
            return this.moveMessage;
        }
        return BLANK;
    }

    public String isDown() {
        if (this == DOWN || this == DOWN_FAIL) {
            return this.moveMessage;
        }
        return BLANK;
    }
}
