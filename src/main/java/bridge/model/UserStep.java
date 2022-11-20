package bridge.model;

import static global.advice.InputValidator.checkMoving;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserStep {

    private final List<String> userStep;

    public UserStep() {
        this.userStep = new ArrayList<>();
    }

    public List<String> getUserStep() {
        return userStep;
    }

    public boolean goOneStep(Bridge bridge, String moving) {
        checkMoving(moving);
        this.userStep.add(moving);
        return bridge.canGoOrNot(this.userStep, moving);
    }

    public boolean isCrossing(Bridge bridge) {
        return bridge.isCrossing(this.userStep.size());
    }

    public UserStep setInit() {
        return new UserStep();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserStep userStep1 = (UserStep) o;
        return Objects.equals(userStep, userStep1.userStep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userStep);
    }


}
