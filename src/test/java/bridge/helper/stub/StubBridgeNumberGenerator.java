package bridge.helper.stub;

import bridge.BridgeNumberGenerator;
import java.util.List;

public class StubBridgeNumberGenerator implements BridgeNumberGenerator {

    private final List<Integer> generateValues;
    private int index = 0;

    public StubBridgeNumberGenerator(List<Integer> generateValues) {
        this.generateValues = generateValues;
    }

    @Override
    public int generate() {
        return generateValues.get(index++);
    }
}
