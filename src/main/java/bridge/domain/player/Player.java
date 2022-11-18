package bridge.domain.player;

public class Player {

    private int playerLocation;
    private boolean success;

    public Player() {
        this.playerLocation = 0;
        this.success = true;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void movePlayerLocation() {
        playerLocation++;
    }
    public void resetPlayerLocation() {
        playerLocation = 0;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
