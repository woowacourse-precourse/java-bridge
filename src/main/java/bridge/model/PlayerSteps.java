package bridge.model;

import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.ArrayList;
import java.util.List;

public class PlayerSteps {
    private List<Node> steps;

    public PlayerSteps(int bridgeSize) {
        steps = new ArrayList<>(bridgeSize);
    }

    public void add(Node node) {
        steps.add(node);
    }

    public boolean compareLastStepWithBridge(Bridge bridge) {
        int compareIndex = steps.size()-1;
        Node lastStep = steps.get(compareIndex);
        return bridge.compareNodeOf(compareIndex, lastStep);
    }
}
