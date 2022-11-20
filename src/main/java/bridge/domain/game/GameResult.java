package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;
import bridge.domain.move.MoveType;

public class GameResult {

    private final Square square;

    private final MoveResult moveResult;

    public GameResult(Square square, MoveResult moveResult) {
        this.square = square;
        this.moveResult = moveResult;
    }

    public GameResult getReversed() {
        return new GameResult(square.getReverse(), MoveResult.NOTHING);
    }

    public Square getSquare() {
        return square;
    }

    public String getMoveResult() {
        return moveResult.symbol();
    }
}
