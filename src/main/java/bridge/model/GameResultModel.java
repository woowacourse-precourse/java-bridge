package bridge.model;

public class GameResultModel {

    private final String resultBridge;
    private final boolean success;
    private final int playtime;

    public GameResultModel(String resultBridge, boolean result, int playtime) {
        this.resultBridge = resultBridge;
        this.success = result;
        this.playtime = playtime;
    }

    public String getResultBridge() {
        return resultBridge;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getPlaytime() {
        return playtime;
    }
}
