package bridge.domain;

import bridge.validation.BridgeValidator;

import java.util.List;

public class Bridge {

    private final List<String> steps;

    public Bridge(List<String> steps) {
        validate(steps);
        this.steps = steps;
    }

    public void validate(List<String> steps) {
        BridgeValidator.check(steps);
    }

    public boolean canMove(int position, String moving) {
        return steps.get(position).equals(moving);
    }

    public int getSize() {
        return steps.size();
    }
}
