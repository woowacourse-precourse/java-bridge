package bridge.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameProgress {

    private final List<MoveResult> gameProgress;

    public GameProgress() {
        this.gameProgress = new ArrayList<>();
    }

    public int getPosition() {
        return gameProgress.size();
    }

    public boolean isSuccessToCrossBridge(int bridgeSize) {
        return isLastOfBridge(bridgeSize) && isLastMoveSuccess();
    }

    private boolean isLastOfBridge(int bridgeSize) {
        return getPosition() == bridgeSize;
    }

    private boolean isLastMoveSuccess() {
        int lastPosition = gameProgress.size() - 1;
        return gameProgress.get(lastPosition).isSuccess();
    }

    public Stream<MoveResult> stream() {
        return gameProgress.stream();
    }

    public void add(String moving, boolean success) {
        gameProgress.add(new MoveResult(moving, success));
    }

    public void clear() {
        gameProgress.clear();
    }
}
