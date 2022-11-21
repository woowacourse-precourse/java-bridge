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
}
