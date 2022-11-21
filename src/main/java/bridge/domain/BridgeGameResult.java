package bridge.domain;

import java.util.Collections;
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
        return new Bridge(this.bridge);
    }

    public List<Boolean> playerMoveResult() {
        return Collections.unmodifiableList(this.playerMoveResult);
    }

    public boolean isFail() {
        return this.playerMoveResult.contains(false);
    }

    public boolean isSuccess() {
        return !this.playerMoveResult.contains(false) && bridge.sizeEqual(this.playerMoveResult.size());
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
        return Objects.equals(this.bridge, that.bridge) && Objects.equals(this.playerMoveResult, that.playerMoveResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bridge, this.playerMoveResult);
    }
}
