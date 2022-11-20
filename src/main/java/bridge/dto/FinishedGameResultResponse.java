package bridge.dto;

import bridge.constant.MoveStatus;
import java.util.List;

public class FinishedGameResultResponse {
    private final List<MoveStatus> statuses;
    private final boolean isSuccess;
    private final int playCount;


    public FinishedGameResultResponse(List<MoveStatus> statuses, boolean isSuccess, int playCount) {
        this.statuses = statuses;
        this.isSuccess = isSuccess;
        this.playCount = playCount;
    }

    public List<MoveStatus> getStatuses() {
        return statuses;
    }

    public int getPlayCount() {
        return playCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
