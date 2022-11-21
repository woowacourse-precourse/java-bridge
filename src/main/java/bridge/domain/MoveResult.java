package bridge.domain;

import static bridge.utils.Move.NO_MOVE;
import static bridge.utils.Move.isMoveUp;
import static bridge.utils.message.GameMessagesUtil.DELIMITER;

import bridge.utils.Move;
import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private final List<String> upMoves;
    private final List<String> downMoves;

    public MoveResult() {
        this.upMoves = new ArrayList<>();
        this.downMoves = new ArrayList<>();
    }

    public void addMove(Move moving, Move result) {
        if (isMoveUp(moving)) {
            addMoveUp(result);
            return;
        }
        addMoveDown(result);
    }

    private void addMoveUp(Move result) {
        upMoves.add(result.getMoving());
        downMoves.add(NO_MOVE.getMoving());
    }

    private void addMoveDown(Move result) {
        downMoves.add(result.getMoving());
        upMoves.add(NO_MOVE.getMoving());
    }

    public String getUpMovesString() {
        return String.join(DELIMITER.getMessage(), upMoves);
    }

    public String getDownMovesString() {
        return String.join(DELIMITER.getMessage(), downMoves);
    }

    public int getStep() {
        return upMoves.size();
    }

    public boolean isFinish(int bridgeSize) {
        return getStep() == bridgeSize;
    }
}
