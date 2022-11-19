package bridge.model;

public class FinalResult {
    private int attempts = 1;
    private boolean success = false;
    private GameCommand command = GameCommand.RETRY;

    public void addAttempts() {
        attempts++;
    }

    public void setSuccess() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean retry() {
        return command == GameCommand.RETRY && !success;
    }
    public void quit() {
        command = GameCommand.QUIT;
    }
}
