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

    public Square getSquare() {
        return square;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    @Override
    public String toString() {
        return String.format("이동 타입 : %s, 이동 결과 : %s",
                square.toString(),
                moveResult.toString());
    }
}
