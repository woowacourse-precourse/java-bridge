package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {
    private final Map<Direction, MovingResults> gameResult;

    public BridgeGameResult() {
        this.gameResult = new HashMap<>();
        initResult();
    }

    private void initResult() {
        gameResult.put(Direction.UP, new MovingResults());
        gameResult.put(Direction.DOWN, new MovingResults());
    }

    public void putMovingResult(Direction direction, MovingResult movingResult) {
        gameResult.keySet()
             .forEach(key -> putMovingResultByDirection(key, direction, movingResult));
    }

    private void putMovingResultByDirection(
            Direction direction,
            Direction selectDirection,
            MovingResult movingResult
    ) {
        MovingResult result = MovingResult.of(direction, selectDirection, movingResult);
        gameResult.get(direction).add(result);
    }

    public void clearResult() {
        gameResult.values().forEach(MovingResults::clear);
    }

    public MovingResults getMovingResultByDirection(Direction direction) {
        return gameResult.get(direction);
    }
}
