package bridge;

import static bridge.Symbols.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private final MoveRecord moveRecord;
    private int current;

    public BridgeGame() {
        moveRecord = new MoveRecord();
        current = 0;
    }

    public void getBridge(BridgeNumberGenerator bridgeNumberGenerator, int size) {
        bridge = new Bridge(bridgeNumberGenerator, size);
    }

    public boolean move(String move) {
        boolean moved = bridge.canGo(current, move);
        moveRecord(move, moved);
        addCurrent(moved);
        return moved;
    }

    private void moveRecord(String move, boolean canMove) {
        if (move.equals(UPPER.getSymbol())) {
            moveRecord.moveUP(current, canMove);
        }
        if (move.equals(DOWN.getSymbol())) {
            moveRecord.moveDOWN(current, canMove);
        }
    }

    private void addCurrent(boolean bool) {
        if (bool) {
            current++;
        }
    }

    public boolean gameResult() {
        return current == bridge.size();
    }

    public boolean retry(String retry) {
        return retry.equals(RETRY.getSymbol());
    }

    public String getString() {
        return moveRecord.getString();
    }
}