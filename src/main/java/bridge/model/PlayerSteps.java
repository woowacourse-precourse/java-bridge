package bridge.model;

import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.ArrayList;
import java.util.List;

public class PlayerSteps {
    private static final String INDEX_OUT_OF_RANGE_FORMAT = "인덱스가 올바르지 않습니다. : %d";

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
        Node currentStepNode = getStepIndexOf(currentStepCount);
        return bridge.compareNodeOf(currentStepCount, currentStepNode);
    }

    public boolean lastStepEquals(Node node) {
        return getStepIndexOf(steps.size() - 1).equals(node);
    }

    private Node getStepIndexOf(int index) {
        try {
            return steps.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException(String.format(INDEX_OUT_OF_RANGE_FORMAT, index));
        }

    }

    public void clearSteps() {
        steps.clear();
    }

    public boolean isUpperStepFor(int index) {
        return getStepIndexOf(index).equals(Node.UP);
    }
}
