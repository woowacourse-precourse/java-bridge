package bridge.domain;

import bridge.validation.BridgeValidator;

import java.util.List;

public class Bridge {

    private final List<String> steps;

    public Bridge(List<String> steps) {
        validateStep(steps);
        this.steps = steps;
    }

    public void validateStep(List<String> steps) {
        BridgeValidator.checkStep(steps);
    }

    public boolean canMove(int position, String moving) {
        validatePosition(position);
        return steps.get(position).equals(moving);
    }

    private void validatePosition(int position) {
        BridgeValidator.checkPosition(position, steps.size());
    }

    public int getSize() {
        return steps.size();
    }
}
