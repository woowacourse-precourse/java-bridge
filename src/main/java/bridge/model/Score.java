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

    public boolean goOneStep(Bridge bridge, String moving) {
        this.userStep.add(moving);
        return bridge.canGoOrNot(this.userStep, moving);
    }

}
