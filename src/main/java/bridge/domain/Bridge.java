package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.exception.BridgeSizeException;
import java.util.List;

public class Bridge {

    private List<String> steps;
    private static final int MIN = 3;
    private static final int MAX = 20;

    public Bridge(int size) {
        validate(size);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.steps = bridgeMaker.makeBridge(size);
    }

    private void validate(int size) throws IllegalArgumentException {
        if (size < MIN || size > MAX) {
            throw new BridgeSizeException(size);
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
