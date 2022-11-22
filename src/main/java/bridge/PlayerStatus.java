package bridge;

public class PlayerStatus {
    private String direction;
    private boolean isMatch;

    public PlayerStatus() {
    }
    public PlayerStatus(String direction, boolean isMatch) {
        this.direction = direction;
        this.isMatch = isMatch;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void update(String direction, boolean isMatch) {
        this.direction = direction;
        this.isMatch = isMatch;
    }
}