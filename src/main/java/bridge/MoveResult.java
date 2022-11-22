package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private List<String> history;
    private GameStatus gameStatus;

    public MoveResult(List<String> history, GameStatus gameStatus) {
        this.history = history;
        this.gameStatus = gameStatus;
    }

    public List<String> getHistory() {
        return new ArrayList<>(this.history);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
