package bridge.model;

import bridge.resources.GameCommand;

import java.util.HashMap;
import java.util.Map;

import static bridge.resources.GameCommand.*;

public class MovementResultManager {
    private final Map<GameCommand, MovementResult> movementResult;

    public MovementResultManager() {
        movementResult = new HashMap<>();
        movementResult.put(UPPER, new MovementResult());
        movementResult.put(LOWER, new MovementResult());
    }

    public void setResult(String moveSpace, boolean canMove) {
        movementResult.get(getBridgeCommand(moveSpace)).setResults(canMove);
        movementResult.get(reverse(moveSpace)).addBlank();
    }

    public void reset() {
        for (MovementResult value : movementResult.values()) {
            value.reset();
        }
    }

    @Override
    public String toString() {
        return movementResult.get(UPPER) +
                "\n" +
                movementResult.get(LOWER);
    }
}
