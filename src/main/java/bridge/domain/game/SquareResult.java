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

    public boolean isSuccess() {
        return moveResult.equals(MoveResult.SUCCESS);
    }

    public boolean isFail() {
        return moveResult.equals(MoveResult.FAIL);
    }


    public String getSuccess() {
        return moveResult.value();
    }

    public String getMoveResult() {
        return moveResult.symbol();
    }

    public Square getSquare() {
        return square;
    }
}
