package bridge;

public class Player {
    private Bridge bridge;
    private int round = 0;
    private int location = -1;
    private boolean alive = true;

    public Player(Bridge bridge) {
        this.bridge = bridge;
    }

    public void startRound() {
        round++;
        location = -1;
        alive = true;
    }

    public boolean movable() {
        if (bridge.hasNextBlock(location) && alive) {
            return true;
        }
        return false;
    }

    public int move(String step) {
        if (movable() && bridge.matchBlockLocation((location + 1), step)) {
            return ++location;
        }

        alive = false;
        return location;
    }
}
