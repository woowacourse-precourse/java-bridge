package bridge.game;

public class Progress {
    String destination;
    boolean success;

    public Progress(String destination, boolean isSuccess) {
        this.destination = destination;
        this.success = isSuccess;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isSuccess() {
        return success;
    }
}
