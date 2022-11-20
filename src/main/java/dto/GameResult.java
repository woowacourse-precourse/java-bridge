package dto;

import model.MoveInformation;
import model.enums.GameStatus;
import java.util.List;
import java.util.Optional;

public class GameResult {

    private Optional<Integer> tryCount;
    private Optional<GameStatus> status;
    private List<MoveInformation> bridgeMoveInformation;

    public GameResult(Optional<Integer> tryCount, Optional<GameStatus> status, List<MoveInformation> bridgeMoveInformation) {
        this.tryCount = tryCount;
        this.status = status;
        this.bridgeMoveInformation = bridgeMoveInformation;
    }

    public Integer getTryCount() {
        return tryCount.get();
    }

    public GameStatus getStatus() {
        return status.get();
    }

    public List<MoveInformation> getBridgeMoveInformation() {
        return bridgeMoveInformation;
    }
}
