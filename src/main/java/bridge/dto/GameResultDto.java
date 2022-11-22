package bridge.dto;

import bridge.domain.GameResult;

public class GameResultDto {
    private int tryCount;
    private GameResult gameResult;

    public GameResultDto() {
        this.tryCount = 0;
        this.gameResult = GameResult.SUCCESS;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void counting() {
        this.tryCount++;
    }

    public void setGameResult(GameResult result) {
        this.gameResult = result;
    }
}
