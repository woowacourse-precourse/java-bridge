package bridge.result;

import java.util.List;

public class Result {
    private final List<String> squares;
    private final GameStatus gameStatus;

    public Result(List<String> squares, GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        this.squares = squares;
    }

    public List<String> getSquares() {
        return squares;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
