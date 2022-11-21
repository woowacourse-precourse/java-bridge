package bridge.domain.player;

public class Player {

    private int playerLocation;
    private boolean cross;

    public Player() {
        this.playerLocation = 0;
        this.cross = true;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void movePlayerLocation() {
        playerLocation++;
    }

    public boolean isCross() {
        return cross;
    }

    public void setCross(boolean cross) {
        this.cross = cross;
    }

    public void resetPlayerLocation() {
        playerLocation = 0;
    }
}
