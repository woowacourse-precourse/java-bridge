package bridge.domain;

import java.util.List;
import java.util.Objects;

public class MoveResultJudgement {
    List<String> bridge;

    public MoveResultJudgement(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean movedResult(String moving, int currentDistance) {
        if (Objects.equals(moving, bridge.get(currentDistance))) {
            return true;
        }
        return false;
    }

    public boolean isGameComplete(String moving, int currentDistance) {
        ValidationUtil.movedValidation(moving);
        return bridge.size() - 1 == currentDistance && Objects.equals(moving, bridge.get(currentDistance));
    }
}
