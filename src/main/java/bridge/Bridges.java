package bridge;

import java.util.List;

public class Bridges {

    private final List<String> bridges;
    private int passIndex = 0;

    public Bridges(List<String> bridges) {
        this.bridges = bridges;
    }

    public boolean tryPass(String moving) {
        if (isAllPassed()) {
            return false;
        }
        boolean isPassed = bridges.get(passIndex).equals(moving);
        if (isPassed) {
            ++passIndex;
        }

        return isPassed;
    }

    public boolean isAllPassed() {
        return this.passIndex >= bridges.size();
    }

    public void init() {
        this.passIndex = 0;
    }
}
