package bridge.result;

import static bridge.result.GameResult.UNKNOWN;

import java.util.Collections;
import java.util.List;

public class Result {
    private final List<String> squares;
    private final GameResult gameResult;

    public Result(List<String> squares, GameResult gameResult) {
        this.gameResult = gameResult;
        this.squares = squares;
    }

    public List<String> getSquares() {
        return squares;
    }

    public GameResult getGameStatus() {
        return gameResult;
    }

    public static Result getEmptyResult() {
        return new Result(Collections.emptyList(), UNKNOWN);
    }
}
