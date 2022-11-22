package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> sequence;

    public Bridge(List<String> sequence) {
        this.sequence = sequence;
    }

    public List<String> getSequence() {
        return sequence;
    }
}
