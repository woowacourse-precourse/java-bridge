package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private List<String> userStep;
    private int retryCount;

    public Score() {
        this.userStep = new ArrayList<>();
        this.retryCount = 1;
    }

    public Score(List<String> userStep) {
        this.userStep = userStep;
        this.retryCount = 1;
    }

    public boolean goOneStep(Bridge bridge, String moving) {
        this.userStep.add(moving);
        return bridge.canGoOrNot(this.userStep, moving);
    }

    public boolean isCrossing(Bridge bridge) {
        return bridge.isCrossing(this.userStep.size());
    }

}
