package bridge.game;

public class Progress {
    String destination;
    boolean isSuccess;

    public Progress(String destination, boolean isSuccess) {
        this.destination = destination;
        this.isSuccess = isSuccess;
    }

    public String getDestination() {
        return destination;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
