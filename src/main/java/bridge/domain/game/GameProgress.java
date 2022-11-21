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
