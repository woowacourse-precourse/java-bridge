package controller;

import model.BridgeMap;
import model.UserMap;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMap bridgeMap;
    private UserMap userMap;
    private int countOfMove;

    public BridgeGame(BridgeMap bridgeMap, UserMap userMap) {
        this.bridgeMap = bridgeMap;
        this.userMap = userMap;
        countOfMove = -1;
    }

    public boolean move(String direction) {
        countOfMove++;

        if (bridgeMap.canMoveMore(direction, countOfMove)) {
            userMap.setContinue(direction, countOfMove);
            return false;
        }

        userMap.setStop(direction, countOfMove);
        return true;
    }

    public int retry(String retryInput) {
        if (retryInput.equals("Q")) {
            return -1;
        }
        return 0;
    }

    public int getCountOfMove() {
        return countOfMove;
    }
}
