package bridge.domain;

public class GameState {
    private boolean fail;
    private int playerPosition;

    public GameState() {
        fail = false;
        playerPosition = 0;
    }

    public int getPlayerPosition() {
        return this.playerPosition;
    }

    public void movePlayer() {
        this.playerPosition += 1;
    }

    public boolean isFail() {
        return this.fail;
    }
}
