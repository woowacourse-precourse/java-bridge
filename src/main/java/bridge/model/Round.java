package bridge.model;

import java.util.List;

public class Round {
    private int currentIndex;

    public Round() {
        currentIndex = 1;
    }

    public boolean isMovable(List<Integer> accessibleIndexes) {
        return accessibleIndexes.contains(currentIndex);
    }
}
