package bridge.domain;

import static bridge.utils.value.GameCommand.*;
import static bridge.utils.value.Move.NO_MOVE;
import static bridge.utils.value.Move.isMoveUp;
import static bridge.utils.message.GameMessagesUtil.DELIMITER;

import bridge.utils.value.GameCommand;
import bridge.utils.value.Move;
import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private Move result;
    private final List<String> upMoves;
    private final List<String> downMoves;

    public MoveResult() {
        this.upMoves = new ArrayList<>();
        this.downMoves = new ArrayList<>();
    }

    public void addMove(Move moving, Move result) {
        this.result = result;

        if (isMoveUp(moving)) {
            addMoveUp(result);
            return;
        }
        addMoveDown(result);
    }

    private void addMoveUp(Move result) {
        upMoves.add(result.getText());
        downMoves.add(NO_MOVE.getText());
    }

    private void addMoveDown(Move result) {
        downMoves.add(result.getText());
        upMoves.add(NO_MOVE.getText());
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

    public GameCommand isFinish(int bridgeSize) {
        if (isEqualIndex(bridgeSize)) {
            return FINISH;
        }
        return PLAY;
    }

    private boolean isEqualIndex(int bridgeSize) {
        return getStep() == bridgeSize;
    }

    public String getResultText() {
        return result.getResultText();
    }
}
