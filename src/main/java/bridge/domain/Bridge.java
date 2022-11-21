package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.List;

public class Bridge {

    private static final int MAX = 20;
    private static final int MIN = 3;
    private static final String SIZE_RANGE_ERROR = "[ERROR]다리길이는 3보다 작거나 20보다 클 수 없습니다. : %d ";

    private List<String> steps;

    public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        validate(size);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.steps = bridgeMaker.makeBridge(size);
    }

    private void validate(int size) throws IllegalArgumentException {
        if (size < MIN || size > MAX) {
            throw new IllegalArgumentException(
                String.format(SIZE_RANGE_ERROR, size));
        }
    }

    public List<String> get() {
        return steps;
    }

    public String getStep(int position) {
        return steps.get(position);
    }

    public String toString() {
        return "Bridge{" +
            "steps=" + steps +
            '}';
    }
}