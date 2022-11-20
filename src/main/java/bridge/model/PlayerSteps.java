package bridge.model;

import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerSteps {
    private List<Node> steps;

    public PlayerSteps(int bridgeSize) {
        steps = new ArrayList<>(bridgeSize);
    }

    public void add(Node node) {
        steps.add(node);
    }

    public int size() {
        return steps.size();
    }

    public boolean isLastStepSameWithBridge(Bridge bridge) {
        int currentStepCount = steps.size() - 1;
        Node currentStepNode = steps.get(currentStepCount);
        return bridge.compareNodeOf(currentStepCount, currentStepNode);
    }

    public boolean lastStepEquals(Node node) {
        return steps.get(steps.size() - 1).equals(node);
    }

    public List<Node> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public void clearSteps() {
        steps.clear();
    }
}
