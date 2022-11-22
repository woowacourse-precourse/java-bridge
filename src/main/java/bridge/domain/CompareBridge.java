package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class CompareBridge {
    private final List<String> bridge;

    public CompareBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSame(String moving, String panel) {
        return moving.equals(panel);
    }

    public List<Boolean> canStepping(Player player) {
        List<String> movingChoices = player.getMovingInputs();
        List<Boolean> moveResults = new ArrayList<>();
        checkSameOrNot(movingChoices, moveResults);
        return moveResults;
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