package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMoving bridgeMoving;
    private List<String> userSelectList;

    public BridgeGame() {
        this.bridgeMoving = new BridgeMoving();
        this.userSelectList = new ArrayList<>();
    }

    // 사용자가 칸을 이동할 때 사용하는 메서드
    public boolean move(String moving) {
        this.userSelectList.add(moving);
        if (bridgeMoving.movingCount()) {
            return false;
        }
        if (!(bridgeMoving.compareList(moving))) {
            return false;
        }
        return true;
    }

    //사용자가 게임을 다시 시도할 때 사용하는 메서드
    public boolean retry(String isRestart) {
        if (isRestart.equals("R")) {
            this.userSelectList = new ArrayList<>();
            bridgeMoving.setMoveCount();
            return true;
        }
        return false;
    }

    public void setBridgeMake(int size) {
        bridgeMoving.setBridgeMaker(size);
    }

    public List<String> getUserSelectList() {
        return userSelectList;
    }

    public List<String> getMakeBridgeList() {
        return bridgeMoving.getMakeBridgeList();
    }
}
