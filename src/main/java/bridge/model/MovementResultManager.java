package bridge.model;

import java.util.HashMap;
import java.util.Map;

public class MovementResultManager {
    private final Map<String, MovementResult> movementResult;

    public MovementResultManager() {
        movementResult = new HashMap<>();
        movementResult.put("U", new MovementResult());
        movementResult.put("D", new MovementResult());
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
        return movementResult.get("U") +
                "\n" +
                movementResult.get("D");
    }

    private String reverse(String moveSpace) {
        if (moveSpace.equals("U")) {
            return "D";
        }
        return "U";
    }
}
