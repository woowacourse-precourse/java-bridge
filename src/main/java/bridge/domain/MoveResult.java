package bridge.domain;

import java.util.Objects;

public class MoveResult {
    private final String controlKey;
    private final boolean matchResult;

    public MoveResult(String controlKey, boolean matchResult) {
        this.controlKey = controlKey;
        this.matchResult = matchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveResult that = (MoveResult) o;
        return matchResult == that.matchResult && Objects.equals(controlKey, that.controlKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlKey, matchResult);
    }

    public boolean isMatchResult() {
        return matchResult;
    }

    public String getControlKey() {
        return controlKey;
    }

}
