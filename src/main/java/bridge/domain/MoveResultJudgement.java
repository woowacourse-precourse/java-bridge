package bridge.domain;

import java.util.List;
import java.util.Objects;

public class MoveResultJudgement {
    List<String> bridge;
    private int currentDistance = 0;

    public MoveResultJudgement(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean movedResult(String moving) {
        if (Objects.equals(moving, bridge.get(currentDistance))) {
            currentDistance++;
            return true;
        }
        return false;
    }

    public boolean isGameComplete(String moving){
        ValidationUtil.movedValidation(moving);
        return bridge.size() - 1 == currentDistance && Objects.equals(moving, bridge.get(currentDistance));
    }
}
