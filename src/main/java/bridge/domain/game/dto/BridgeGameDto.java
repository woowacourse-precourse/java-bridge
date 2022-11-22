package bridge.domain.game.dto;

public class BridgeGameDto {
    private int location;
    private int attempt;

    public BridgeGameDto() {
        this.location = 0;
        this.attempt = 1;
    }

    public void resetLocation() {
        location = 0;
    }

    public void addLocation() {
        location++;
    }

    public void addAttempt() {
        attempt++;
    }

    public int getLocation() {
        return location;
    }

    public int getAttempt() {
        return attempt;
    }
}
