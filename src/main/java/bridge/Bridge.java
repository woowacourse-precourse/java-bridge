package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridges;

    public Bridge(List<String> bridge) {
        this.bridges = bridge;
    }

    public boolean matchStep(int round, String controlKey) {
        return bridges.get(round).matches(controlKey);
    }

}
