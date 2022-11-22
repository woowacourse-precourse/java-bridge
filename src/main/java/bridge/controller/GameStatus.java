package bridge.controller;

public class GameStatus {

    private boolean success;
    private boolean running;
    private int attempt;

    public GameStatus() {
        this.success = false;
        this.running = true;
        this.attempt = 1;
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

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
}
