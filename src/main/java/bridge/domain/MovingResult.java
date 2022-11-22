package bridge.domain;

import bridge.util.Validation;

import java.util.List;
import java.util.Objects;

public class MovingResult {
    private final List<String> bridge;

    public MovingResult(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean movedResult(String moving, int distance) {
        return Objects.equals(moving, bridge.get(distance));
    }

    public boolean isComplete(String moving, int distance) {
        Validation.movedValidation(moving);
        return bridge.size() - 1 == distance && Objects.equals(moving, bridge.get(distance));
    }
}