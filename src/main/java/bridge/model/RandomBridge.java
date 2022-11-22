package bridge.model;

import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;

import java.util.List;

public class RandomBridge {
    private final List<String> randomBridge;

    public RandomBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.randomBridge = bridgeMaker.makeBridge(size);
    }

    public boolean isRight(String moving, int index) {
        return randomBridge.get(index).equals(moving);
    }

    public boolean isEndIndex(int index) {
        return this.randomBridge.size() == index + 1;
    }
}
