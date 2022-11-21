package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> shape;

    public Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.shape = bridgeMaker.makeBridge(size);
    }

    public List<String> askCurrentShape(int currentSection) {
        return shape.subList(0, currentSection);
    }

    public boolean isLastBridgeSection(int currentSection) {
        return shape.size() == currentSection;
    }
}
