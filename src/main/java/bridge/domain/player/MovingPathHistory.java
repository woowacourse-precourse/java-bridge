package bridge.domain.player;

import bridge.domain.game.BridgeTile;
import bridge.exception.domain.WrongBridgeTileException;
import java.util.ArrayList;
import java.util.List;

public class MovingPathHistory {

    private static final String HISTORY_SEPARATOR = " | ";
    private static final String CORRECT_MOVE = "O";
    private static final String WRONG_MOVE = "X";
    private static final String NOT_MOVE = " ";

    private final List<String> upStepHistory = new ArrayList<>();
    private final List<String> downStepHistory = new ArrayList<>();

    public void updateHistory(final BridgeTile playerStep, boolean movable) {
        List<String> target = upStepHistory;
        List<String> noneTarget = downStepHistory;

        if (playerStep == BridgeTile.DOWN) {
            target = downStepHistory;
            noneTarget = upStepHistory;
        }
        processHistory(target, noneTarget, movable);
    }

    private void processHistory(final List<String> target, final List<String> noneTarget, boolean movable) {
        target.add(mapToResult(movable));
        noneTarget.add(NOT_MOVE);
    }

    private String mapToResult(boolean movable) {
        if (movable) {
            return CORRECT_MOVE;
        }
        return WRONG_MOVE;
    }

    public String getPlayerTargetTileHistory(final BridgeTile targetTile) {
        if (targetTile == BridgeTile.UP) {
            return mapToPlayerStepHistoryLog(upStepHistory);
        }
        if (targetTile == BridgeTile.DOWN) {
            return mapToPlayerStepHistoryLog(downStepHistory);
        }
        throw new WrongBridgeTileException();
    }

    private String mapToPlayerStepHistoryLog(final List<String> targetHistory) {
        return String.join(HISTORY_SEPARATOR, targetHistory);
    }

    public void clear() {
        this.upStepHistory.clear();
        this.downStepHistory.clear();
    }
}
