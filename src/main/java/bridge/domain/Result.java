package bridge.domain;

import java.util.List;

public class Result {

    private final List<String> bridge;
    private final boolean survive;
    private final boolean victory;
    private final int gameCount;

    private Result(List<String> bridge, boolean survive, boolean victory, int gameCount) {
        this.bridge = bridge;
        this.survive = survive;
        this.victory = victory;
        this.gameCount = gameCount;
    }

    public static Result of(List<String> bridge, boolean survive, boolean victory, int gameCount) {
        return new Result(bridge, survive, victory, gameCount);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isSurvive() {
        return survive;
    }

    public boolean isVictory() {
        return victory;
    }

    public int getGameCount() {
        return gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Result result = (Result) o;

        if (survive != result.survive) {
            return false;
        }
        if (victory != result.victory) {
            return false;
        }
        return bridge.equals(result.bridge);
    }

    @Override
    public int hashCode() {
        int result = bridge.hashCode();
        result = 31 * result + (survive ? 1 : 0);
        result = 31 * result + (victory ? 1 : 0);
        return result;
    }
}
