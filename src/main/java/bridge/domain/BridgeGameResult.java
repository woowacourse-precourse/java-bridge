package bridge.domain;

import java.util.List;
import java.util.Objects;

public class BridgeGameResult {
    private final Bridge bridge;
    private final List<Boolean> attemptsResult;

    public BridgeGameResult(Bridge bridge, List<Boolean> booleans) {
        this.bridge = bridge;
        this.attemptsResult = booleans;
    }

    public Bridge bridge() {
        return this.bridge;
    }

    public List<Boolean> attemptsResult() {
        return this.attemptsResult;
    }

    public boolean isFail() {
        return attemptsResult.contains(Boolean.FALSE);
    }

    public boolean isSuccess() {
        return !attemptsResult.contains(Boolean.FALSE) && bridge.sizeEqual(attemptsResult.size());
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
        return Objects.equals(bridge, that.bridge) && Objects.equals(attemptsResult, that.attemptsResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge, attemptsResult);
    }
}
