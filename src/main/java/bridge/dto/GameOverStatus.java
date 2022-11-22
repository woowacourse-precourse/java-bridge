package bridge.dto;

import java.util.List;

public class GameOverStatus {
    boolean isSuccess;
    List<CorrectInfo> bridge;
    int playCount;

    public GameOverStatus(boolean isSuccess, List<CorrectInfo> bridge, int playCount) {
        this.isSuccess = isSuccess;
        this.bridge = bridge;
        this.playCount = playCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public List<CorrectInfo> getBridge() {
        return bridge;
    }

    public int getPlayCount() {
        return playCount;
    }
}
