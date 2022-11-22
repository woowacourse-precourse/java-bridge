package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareBridge {
    private final List<String> bridge;
    private final List<Boolean> moveResults;

    public CompareBridge(List<String> bridge) {
        this.bridge = bridge;
        this.moveResults = new ArrayList<>();
    }

    public boolean isSame(String moving, String panel) {
        return moving.equals(panel);
    }

    public List<Boolean> canStepping(Player player) {
        checkSameOrNot(player.getMovingChoices(), moveResults);
        return Collections.unmodifiableList(moveResults);
    }

    public void checkSameOrNot(List<String> movingChoices, List<Boolean> moveResults) {
        for (int index = 0; index < movingChoices.size(); index++) {
            if (isSame(movingChoices.get(index), bridge.get(index))) {
                moveResults.add(true);
            }
            if (!isSame(movingChoices.get(index), bridge.get(index))) {
                moveResults.add(false);
            }
        }
    }
}