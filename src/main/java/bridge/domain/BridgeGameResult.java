package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {

    private final Map<Round, MoveResult> result = new HashMap<>();
    private final Map<Round, Direction> move = new HashMap<>();

    public BridgeGameResult() {
    }

    public void addResult(Round round, MoveResult moveResult, Direction direction) {
        result.put(round, moveResult);
        move.put(round, direction);
    }

    public void reset() {
        result.clear();
    }

    public List<List<MoveResult>> getResult() {
        if (result.isEmpty()) {
            return List.of();
        }
        return List.of(getMoveResults(Direction.UP), getMoveResults(Direction.DOWN));
    }

    private List<MoveResult> getMoveResults(Direction direction) {
        return Round.naturalOrderWithSize(result.size()).stream()
                .map(round -> checkRound(round, direction))
                .collect(toList());
    }

    private MoveResult checkRound(Round round, Direction direction) {
        Direction moveDirection = move.get(round);
        if (moveDirection != direction) {
            return MoveResult.NOT_MOVE;
        }
        return result.get(round);
    }
}
