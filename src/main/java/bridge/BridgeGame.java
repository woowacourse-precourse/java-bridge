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

    public void move(String move) {
        boolean canMove = canMove(move);
        if (move.equals(UPPER.getSymbol())) {
            moveRecord.moveUP(current, canMove);
        }
        if (move.equals(DOWN.getSymbol())) {
            moveRecord.moveDOWN(current, canMove);
        }
    }

    private boolean canMove(String move){
        if(bridge.canGo(current, move)){
            current++;
            return true;
        }
        return false;
    }

    public boolean gameResult(){
        return current == bridge.size();
    }

    public boolean retry(String retry) {
        return retry.equals(RETRY.getSymbol());
    }
}
