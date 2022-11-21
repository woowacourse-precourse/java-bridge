package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class CompareBridge {
    private Player player;
    private List<String> bridge;

    public CompareBridge(Player player, List<String> bridge) {
        this.player = player;
        this.bridge = bridge;
    }

    public boolean isSame(String moving, String panel) {
        return moving.equals(panel);
    }

    public List<Boolean> stepping(Player player, List<String> bridge) {
        List<String> movingChoices = player.getMovingInputs();
        List<Boolean> moveResults = new ArrayList<>();
        int index = 0;
        for (String moving : movingChoices) {
            if (isSame(moving, bridge.get(index))) {
                moveResults.add(true);
            }
            if (!isSame(moving, bridge.get(index))) {
                moveResults.add(false);
            }
            index++;
        }
        return moveResults;
    }
}