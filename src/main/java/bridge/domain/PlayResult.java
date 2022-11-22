package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {

    private final List<MoveStatus> playResult = new ArrayList<>();
    private final TryCount tryCount = new TryCount();

    public void updateResult(MoveStatus moveStatus) {
        playResult.add(moveStatus);
    }

    public void deletePreviousResult() {
        tryCount.updateTryCount();
        playResult.remove(playResult.size() - 1);
    }

    public List<MoveStatus> getPlayResult() {
        return playResult;
    }

    public TryCount getTryCount() {
        return tryCount;
    }
}
