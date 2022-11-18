package bridge.utill;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestBridgeGenerator implements BridgeNumberGenerator {
    private List<Integer> bridge = new ArrayList<>();
    private int pointer = 0;

    public List<String> generate(List<Integer> bridge) {
        pointer = 0;
        this.bridge = bridge;
        BridgeMaker bridgeMaker = new BridgeMaker(this);
        return bridgeMaker.makeBridge(bridge.size());
    }

    @Override
    public int generate() {
        return this.bridge.get(pointer++);
    }
}
