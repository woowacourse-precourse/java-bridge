package dto;

import model.enums.GameStatus;
import model.enums.MoveResult;
import java.util.List;
import java.util.Optional;

public class GameResult {

    private Optional<Integer> tryCount;
    private Optional<GameStatus> status;
    private List<MoveResult> moveResult;

    public GameResult(Optional<Integer> tryCount, Optional<GameStatus> status, List<MoveResult> moveResult) {
        this.tryCount = tryCount;
        this.status = status;
        this.moveResult = moveResult;
    }

    public Integer getTryCount() {
        return tryCount.get();
    }

    public GameStatus getStatus() {
        return status.get();
    }

    public List<MoveResult> getMoveResult() {
        return moveResult;
    }
}
