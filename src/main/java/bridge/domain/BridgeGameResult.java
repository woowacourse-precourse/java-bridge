package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {

    private final Map<Round, PlayerMove> result = new HashMap<>();

    public BridgeGameResult() {
    }

    public void addResult(Round round, PlayerMove playerMove) {
        result.put(round, playerMove);
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
        PlayerMove playerMove = result.get(round);
        if (playerMove.isNotSameDirection(direction)) {
            return MoveResult.NOT_MOVE;
        }
        return playerMove.getMoveResult();
    }

    public Victory checkPassed() {
        long failCount = Round.naturalOrderWithSize(result.size()).stream()
                .map(result::get)
                .filter(PlayerMove::isFail)
                .count();
        return Victory.getEnum(failCount);
    }
}
