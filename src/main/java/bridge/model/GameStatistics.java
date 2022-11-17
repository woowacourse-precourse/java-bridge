package bridge.model;

public class GameStatistics {
    private String gameResult;
    private int totalTryCount;

    public GameStatistics(String gameResult, int totalTryCount) {
        this.gameResult = gameResult;
        this.totalTryCount = totalTryCount;
    }

    public String getGameResult() {
        return gameResult;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }
}
