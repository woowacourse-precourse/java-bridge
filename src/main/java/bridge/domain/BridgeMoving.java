package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

// 다리를 이동할 때 필요한 조건이 담겨있는 클래스
public class BridgeMoving {

    private BridgeMaker bridgeMaker;
    private List<String> makeBridgeList;
    private int size;
    private int moveCount = 0;

    public BridgeMoving() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void setBridgeMaker(int size) {
        this.size = size;
        this.makeBridgeList = bridgeMaker.makeBridge(size);
    }

    public void setMoveCount() {
        this.moveCount = 0;
    }

    // 움직인 횟수와 다리의 길이가 같으면 true return
    public boolean movingCount() {
        moveCount += 1;
        return moveCount == size;
    }

    // 움직인 위치가 다리의 위치와 같으면 true return
    public boolean compareList(String moving) {
        return moving.equals(makeBridgeList.get(moveCount-1));
    }

    public List<String> getMakeBridgeList() {
        return makeBridgeList;
    }
}
