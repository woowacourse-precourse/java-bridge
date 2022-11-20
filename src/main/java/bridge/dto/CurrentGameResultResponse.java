package bridge.dto;

import bridge.constant.MoveStatus;
import java.util.List;

public class CurrentGameResultResponse {
    private final List<MoveStatus> moveStatuses;

    public CurrentGameResultResponse(List<MoveStatus> moveStatuses) {
        this.moveStatuses = moveStatuses;
    }

    public List<MoveStatus> getMoveStatuses() {
        return moveStatuses;
    }
}
