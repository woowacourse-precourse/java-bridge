package bridge.Domain;

public class Player {
    private int position;

    public Player() {
        this.position = 0;
    }

    public void movePlayer() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isPlayerInEndOfBridge(Bridge bridge) {
        return bridge.isBridgeEnd(position);
    }

    public void initPosition() {
        this.position = 0;
    }
}
