package bridge.domain.model;

import bridge.domain.enums.Status;

public class GameResult {

    private final ScoreMap scoreMap;
    private final Status result;
    private final int tryCount;

    public GameResult(ScoreMap scoreMap, Status result, int tryCount) {
        this.result = result;
        this.scoreMap = scoreMap;
        this.tryCount = tryCount;
    }

    public String getScoreMap() {
        return scoreMap.toString();
    }

    public String getResult() {
        return result.getMessage();
    }

    public String getTryCount() {
        return String.valueOf(tryCount);
    }
}
