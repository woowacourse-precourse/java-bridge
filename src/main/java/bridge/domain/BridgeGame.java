package bridge.domain;

import bridge.util.BridgePosition;
import bridge.util.GameCommand;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeGame {

    private final User user;
    private int trialCount;

    public BridgeGame(User user) {
        this.user = user;
        trialCount = 1;
    }

    public boolean move(String movingPosition) {
        return user.move(movingPosition);
    }

    public boolean retry(String selectedProgress) {
        if (GameCommand.RETRY.isEqual(selectedProgress)) {
            user.retry();
            upTrialCount();
            return true;
        }
        return false;
    }

    private void upTrialCount() {
        trialCount++;
    }

    public List<String> getUpBridgeMoveResult() {
        return IntStream.range(0, user.getUserPoint())
                .mapToObj(index -> user.getBlockResult(BridgePosition.UP, index))
                .collect(Collectors.toList());
    }

    public List<String> getDownBridgeResult() {
        return IntStream.range(0, user.getUserPoint())
                .mapToObj(index -> user.getBlockResult(BridgePosition.DOWN, index))
                .collect(Collectors.toList());
    }

    public boolean isFinished() {
        return user.isEndPoint();
    }

    public int getTrialCount() {
        return trialCount;
    }
}
