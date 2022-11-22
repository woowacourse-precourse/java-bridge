package bridge.model;

import java.util.HashMap;
import java.util.Map;

import static bridge.resources.GameConfig.*;

public class MovementResultManager {
    private final Map<String, MovementResult> movementResult;

    public MovementResultManager() {
        movementResult = new HashMap<>();
        movementResult.put(UPPER, new MovementResult());
        movementResult.put(LOWER, new MovementResult());
    }

    public void setResult(String moveSpace, boolean canMove) {
        movementResult.get(moveSpace).setResults(canMove);
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

    private String reverse(String moveSpace) {
        if (moveSpace.equals(UPPER)) {
            return LOWER;
        }
        return UPPER;
    }
}
