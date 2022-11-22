package bridge;

import bridge.command.Movement;
import bridge.path.Path;

public class BridgeGame {

    private final Bridge bridge;
    private Actor actor = new Actor();
    private int numTry = 1;

    private BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
    }

    public static BridgeGame of(final Bridge bridge) {
        return new BridgeGame(bridge);
    }

    public Path onMove(final Movement movement) {
        actor.addMovement(movement);
        return actor.move(bridge);
    }

    public void onRetry() {
        actor = new Actor();
        numTry++;
    }

    public boolean completes() {
        return bridge.getPossibleMovements().size() == actor.numMoves();
    }

    public int getNumTry() {
        return numTry;
    }
}
