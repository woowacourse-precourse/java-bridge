package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {

    private final List<Boolean> gameResult = new ArrayList<>();

    public void add(boolean result) {
        gameResult.add(result);
    }

    public boolean isGameOver() {
        return !gameResult.get(gameResult.size() - 1);
    }

    public List<Boolean> getGameResult() {
        return Collections.unmodifiableList(gameResult);
    }

}
