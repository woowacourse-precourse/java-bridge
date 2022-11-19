package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMoving bridgeMoving;

    public BridgeGame() {
        this.bridgeMoving = new BridgeMoving();
    }

    public void setBridgeMake(int size) {
        bridgeMoving.setBridgeMaker(size);
    }

    public List<String> getMakeBridgeList() {
        return bridgeMoving.getMakeBridgeList();
    }
}
