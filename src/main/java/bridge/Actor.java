package bridge;

import bridge.command.Movement;
import bridge.path.Path;

import java.util.ArrayList;
import java.util.List;

public class Actor {

    private final List<Movement> movements = new ArrayList<>();

    public void addMovement(final Movement movement) {
        movements.add(movement);
    }

    public Path move(final Bridge bridge) {
        return Path.of(bridge.getPossibleMovements(), movements);
    }
}
