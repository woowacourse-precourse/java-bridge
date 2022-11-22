package bridge.domain.bridge.maker;

import bridge.BridgeNumberGenerator;
import java.util.List;

public class BridgeMakerFake implements BridgeNumberGenerator {
    private final List<Integer> inputs;

    public BridgeMakerFake(List<Integer> inputs) {
        this.inputs = inputs;
    }

    @Override
    public int generate() {
        return inputs.remove(0);
    }
}
