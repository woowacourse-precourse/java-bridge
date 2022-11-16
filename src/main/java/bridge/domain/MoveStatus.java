package bridge.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MoveStatus {
    UP("U", "O"),
    DOWN("D", "O"),
    FAIL("", "X");

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
        return FAIL;
    }
}
