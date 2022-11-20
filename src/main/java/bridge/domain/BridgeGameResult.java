package bridge.domain;

import java.util.List;
import java.util.Objects;

public class BridgeGameResult {
    private final Bridge bridge;
    private final List<Boolean> playerMoveResult;

    public BridgeGameResult(Bridge bridge, List<Boolean> booleans) {
        this.bridge = bridge;
        this.playerMoveResult = booleans;
    }

    public Bridge bridge() {
        return this.bridge;
    }

    public List<Boolean> playerMoveResult() {
        return this.playerMoveResult;
    }

    public boolean isFail() {
        return playerMoveResult.contains(Boolean.FALSE);
    }

    public boolean isSuccess() {
        return !playerMoveResult.contains(Boolean.FALSE) && bridge.sizeEqual(playerMoveResult.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeGameResult that = (BridgeGameResult) o;
        return Objects.equals(bridge, that.bridge) && Objects.equals(playerMoveResult, that.playerMoveResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge, playerMoveResult);
    }
}
