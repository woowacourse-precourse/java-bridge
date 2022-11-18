package bridge.controller;

public class GameStatus {

    private boolean success;
    private boolean running;

    public GameStatus() {
        this.success = false;
        this.running = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
