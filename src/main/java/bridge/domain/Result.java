package bridge.domain;

import bridge.application.BridgeGame;
import java.util.List;

public class Result {

    private final List<String> bridge;
    private final boolean survive;
    private final boolean victory;
    private final int gameCount;

    private Result(BridgeGame bridgeGame, boolean survive, boolean victory) {
        this.bridge = bridgeGame.getCurrentBridge();
        this.gameCount = bridgeGame.getGameCount();
        this.survive = survive;
        this.victory = victory;
    }

    public static Result of(BridgeGame bridgeGame, boolean survive, boolean victory) {
        return new Result(bridgeGame, survive, victory);
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
        if (gameCount != result.gameCount) {
            return false;
        }
        return bridge.equals(result.bridge);
    }

    @Override
    public int hashCode() {
        int result = bridge.hashCode();
        result = 31 * result + (survive ? 1 : 0);
        result = 31 * result + (victory ? 1 : 0);
        result = 31 * result + gameCount;
        return result;
    }
}
