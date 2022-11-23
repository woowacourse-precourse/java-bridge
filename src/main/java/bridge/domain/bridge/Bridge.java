package bridge.domain.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
    }

    public boolean isCorrect(int index, String movingType) {
        return bridge.get(index)
                .equals(movingType);
    }

    public boolean canMove(int bridgeIndex) {
        return bridgeIndex < bridge.size() - 1;
    }
}
