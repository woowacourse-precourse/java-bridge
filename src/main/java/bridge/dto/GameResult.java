package bridge.dto;

import bridge.model.MoveInformation;
import java.util.List;
import java.util.Optional;

public class GameResult {

    private Optional<Integer> tryCount;
    private Optional<Boolean> succeed;
    private List<MoveInformation> bridgeMoveInformation;

    public GameResult(Optional<Integer> tryCount, Optional<Boolean> succeed,
            List<MoveInformation> bridgeMoveInformation) {
        this.tryCount = tryCount;
        this.succeed = succeed;
        this.bridgeMoveInformation = bridgeMoveInformation;
    }

    public Integer tryCount() {
        return tryCount.get();
    }

    public boolean succeed() {
        return succeed.get();
    }

    public List<MoveInformation> getBridgeMoveInformation() {
        return bridgeMoveInformation;
    }
}
