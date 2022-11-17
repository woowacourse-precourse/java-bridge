package bridge.domain.player;

public class Player {

    private int playerLocation;

    public Player() {
        this.playerLocation = 0;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void movePlayerLocation() {
        playerLocation++;
    }
}
