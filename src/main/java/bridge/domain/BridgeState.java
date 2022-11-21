package bridge.domain;

import bridge.util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeState {

    private static final String SPACE = " ";

    private final List<String> upper = new ArrayList<>();
    private final List<String> lower = new ArrayList<>();

    public void update(StepResult stepResult) {
        if (isUpperMoving(stepResult)) {
            upper.add(stepResult.getResult());
            lower.add(SPACE);
        }

        if (isLowerMoving(stepResult)) {
            lower.add(stepResult.getResult());
            upper.add(SPACE);
        }
    }

    private boolean isLowerMoving(StepResult stepResult) {
        return stepResult.getDirection().equals(Constant.LOWER_MOVING);
    }

    private boolean isUpperMoving(StepResult stepResult) {
        return stepResult.getDirection().equals(Constant.UPPER_MOVING);
    }

    public void clear() {
        upper.clear();
        lower.clear();
    }

    public List<String> getUpperBridge() {
        return Collections.unmodifiableList(upper);
    }

    public List<String> getLowerBridge() {
        return Collections.unmodifiableList(lower);
    }
}
