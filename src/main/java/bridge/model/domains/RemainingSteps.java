package bridge.model.domains;

import bridge.model.domains.validator.BridgeValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 사용자가 아직 건너야 할 다리 칸 정보를 저장 및 삭제하는 클래스
 */
public class RemainingSteps {

    private final Queue<String> steps = new LinkedList<>();

    public RemainingSteps(List<String> bridge) throws IllegalArgumentException, NullPointerException {
        BridgeValidator.validateBridge(bridge);
        initializeSteps(bridge);
    }

    private void initializeSteps(List<String> bridge) {
        this.steps.addAll(bridge);
    }

    public boolean isMovableStep(String moving) throws IllegalStateException {
        String movableStep = steps.poll();
        validateStatus(movableStep);
        return movableStep.equals(moving);
    }

    private void validateStatus(String polledValue) {
        if (polledValue == null) {
            throw new IllegalStateException("더 이상 건너야 할 칸 정보가 없습니다.");
        }
    }

    public boolean isEmpty() {
        return steps.isEmpty();
    }
}
