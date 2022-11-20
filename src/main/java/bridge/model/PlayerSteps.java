package bridge.model;

import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerSteps {
    private static final String EMPTY_STEPS = "steps가 비어있습니다.";
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
        if(steps.isEmpty()) {
            throw new IllegalStateException(EMPTY_STEPS);
        }

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
