package bridge.domain.model;

import bridge.domain.enums.Move;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrectWay(Move direction, int nextIndex) {
        return bridge.get(nextIndex)
                .equals(direction.name());
    }

    public int size() {
        return bridge.size();
    }
}
