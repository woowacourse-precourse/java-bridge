package bridge;

import bridge.command.Movement;
import bridge.path.Path;

public class BridgeGame {

    private final Bridge bridge;
    private Actor actor = new Actor();

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

    public void retry() {
    }
}
