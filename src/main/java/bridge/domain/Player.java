package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final String EXCEPTION_MESSAGE_OVER_NUMBER = "[ERROR] 최대 시도 횟수를 넘었습니다!";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private final List<String> moveInfo;
    private int totalTry;
    private boolean isMove;

    public Player() {
        moveInfo = new ArrayList<>();
        totalTry = 0;
        isMove = false;
    }

    public void InitRetryPlayer() {
        moveInfo.clear();

        validateTotalTry();
        totalTry++;

        isMove = false;
    }

    private void validateTotalTry(){
        if(totalTry >= Integer.MAX_VALUE){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OVER_NUMBER);
        }
    }

    public void updateMoveInfo(String move) {
        moveInfo.add(move);
    }

    public void setMoveResult(boolean result) {
        this.isMove = result;
    }

    public boolean isPlayerMove(Bridge bridge) {
        int now = moveInfo.size() - 1;
        return (moveInfo.get(now))
                .equals(bridge.getNowCompartment(now));
    }

    public boolean isClearGame(Bridge bridge) {
        return (((moveInfo.size()) == (bridge.getBridgeLength())) && isMove);
    }

    public List<String> getMoveInfo() {
        return moveInfo;
    }

    public boolean getIsMove() {
        return isMove;
    }
}
