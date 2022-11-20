package bridge.game;

public class Move {
    String destination;
    boolean success;

    public Move(String destination, boolean isSuccess) {
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
