package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Moving {

    private final static String NOT_MOVING = " ";

    private Map<Move, List<String>> moving;

    public Moving() {
        initialize();
    }

    public Moving add(Move userMove, Result result) {
        addMovingResult(Move.UP, userMove, result);
        addMovingResult(Move.DOWN, userMove, result);
        return this;
    }

    public Result getResult() {
        boolean isSuccess = Arrays.stream(Move.values())
                .anyMatch(moving -> getRecentMovingResult(moving).equals(Result.SUCCESS.getResultSymbol()));
        return Result.getResultBySuccess(isSuccess);
    }

    public void initialize() {
        this.moving = new HashMap<>();
        moving.put(Move.UP, new ArrayList<>());
        moving.put(Move.DOWN, new ArrayList<>());
    }

    private void addMovingResult(Move baseMove, Move userMove, Result result) {
        if (userMove.equals(baseMove)) {
            getMovingResult(baseMove).add(result.getResultSymbol());
            return;
        }
        getMovingResult(baseMove).add(NOT_MOVING);
    }

    public List<String> getMovingResult(Move move) {
        return moving.get(move);
    }

    private String getRecentMovingResult(Move move) {
        List<String> movingResult = getMovingResult(move);
        return movingResult.get(movingResult.size() - 1);
    }
}
