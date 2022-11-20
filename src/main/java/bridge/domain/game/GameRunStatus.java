package bridge.domain.game;

public class GameRunStatus {

    private boolean isStop;

    public GameRunStatus() {
        this.isStop = false;
    }

    public static GameRunStatus makeGameRunStatus() {
        return new GameRunStatus();
    }

    public void stop() {
        isStop = true;
    }

    public boolean isStop() {
        return isStop;
    }
}
