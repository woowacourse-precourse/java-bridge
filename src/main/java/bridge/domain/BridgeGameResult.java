package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {
    private final Map<Round, MoveResult> result = new HashMap<>();
    private final Map<Round, Move> move = new HashMap<>();

    public BridgeGameResult() {
    }

    public void addResult(Round round, MoveResult moveResult, Move move) {
        result.put(round, moveResult);
        this.move.put(round, move);
    }

    public void reset() {
        result.clear();
    }

    public List<List<MoveResult>> getResult() {
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return List.of(getMovingResults(Move.UP), getMovingResults(Move.DOWN));
    }

    private List<MoveResult> getMovingResults(Move move) {
        return Round.getRoundsWithSizeOrderByAsc(result.size())
                .stream()
                .map(round -> getMovingResult(round, move))
                .collect(toList());
    }

    private MoveResult getMovingResult(Round round, Move move) {
        Move moveMove = this.move.get(round);
        if (moveMove != move) {
            return MoveResult.FAIL;
        }
        return result.get(round);
    }
}
