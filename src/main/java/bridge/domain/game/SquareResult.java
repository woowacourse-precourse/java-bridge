package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;

public class SquareResult {

    private final Square square;

    private final MoveResult moveResult;

    public SquareResult(Square square, MoveResult moveResult) {
        this.square = square;
        this.moveResult = moveResult;
    }

    public SquareResult getReversed() {
        return new SquareResult(square.getReverse(), MoveResult.NOTHING);
    }

    public boolean isMoveSuccess() {
        return moveResult.equals(MoveResult.SUCCESS);
    }

    public String getMoveResult() {
        return moveResult.symbol();
    }

    public Square getSquare() {
        return square;
    }
}
