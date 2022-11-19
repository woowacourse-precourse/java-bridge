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

    public BridgeMoving() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void setBridgeMaker(int size) {
        this.size = size;
        this.makeBridgeList = bridgeMaker.makeBridge(size);
    }

    public List<String> getMakeBridgeList() {
        return makeBridgeList;
    }
}
