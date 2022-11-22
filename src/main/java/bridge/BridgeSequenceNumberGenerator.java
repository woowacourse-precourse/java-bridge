package bridge;

import java.util.List;

public class BridgeSequenceNumberGenerator implements BridgeNumberGenerator {
    private List<Integer> sequence;
    private int idx = 0;

    public BridgeSequenceNumberGenerator(List<Integer> sequence) {
        this.sequence = sequence;
    }

    @Override
    public int generate() {
        if (idx < sequence.size())
            return sequence.get(idx++);
        return 0;
    }
}
