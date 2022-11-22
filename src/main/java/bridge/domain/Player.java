package bridge.domain;

import bridge.exception.TotalTryMaxException;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> moveInfo;
    private int totalTry;
    private boolean isMove;

    public Player() {
        moveInfo = new ArrayList<>();
        totalTry = 0;
        isMove = true;
    }

    public void initRetryPlayer() {
        moveInfo.clear();

        validateTotalTry();
        totalTry++;

        isMove = true;
    }

    private void validateTotalTry() {
        if (totalTry >= Integer.MAX_VALUE) {
            throw new TotalTryMaxException();
        }
    }

    public void updateMoveInfo(String move) {
        moveInfo.add(move);
    }

    public boolean isPlayerMove(Bridge bridge) {
        int now = moveInfo.size() - 1;
        isMove = (moveInfo.get(now)).equals(bridge.nowSpace(now));
        return isMove;
    }

    public boolean isClearGame(Bridge bridge) {
        return (((moveInfo.size()) == (bridge.bridgeLength())) && isMove);
    }

    public List<String> getMoveInfo() {
        return moveInfo;
    }

    public boolean getIsMove() {
        return isMove;
    }

    public int getTotalTry() {
        return totalTry;
    }
}
