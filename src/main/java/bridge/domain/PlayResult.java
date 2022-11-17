package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {

    private final List<MoveStatus> playResult = new ArrayList<>();
    private int tryCount = 1;

    public void updateResult(String spaceToMove, boolean canGo) {
        playResult.add(MoveStatus.findBySpaceToMove(spaceToMove, canGo));
    }

    public void updateTryCount() {
        tryCount++;
    }

    public List<MoveStatus> getPlayResult() {
        return playResult;
    }

    public int getTryCount() {
        return tryCount;
    }
}
