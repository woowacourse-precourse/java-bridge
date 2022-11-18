package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {

    private final List<MoveStatus> playResult = new ArrayList<>();
    private int tryCount = 1;

    public void updateResult(MoveStatus moveStatus) {
        playResult.add(moveStatus);
    }

    public void retry() {
        tryCount++;
        playResult.remove(playResult.size() - 1);
    }

    public List<MoveStatus> getPlayResult() {
        return playResult;
    }

    public int getTryCount() {
        return tryCount;
    }
}
