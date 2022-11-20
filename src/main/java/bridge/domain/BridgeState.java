package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {

    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private static final String SPACE = " ";

    private List<String> upper = new ArrayList<>();
    private List<String> lower = new ArrayList<>();

    public void update(StepResult stepResult) {
        if (stepResult.getDirection().equals(UPPER)) {
            upper.add(stepResult.getResult());
            lower.add(SPACE);
        }

        if (stepResult.getDirection().equals(LOWER)) {
            lower.add(stepResult.getResult());
            upper.add(SPACE);
        }
    }

    public void clear() {
        upper.clear();
        lower.clear();
    }

    public List<String> getUpperBridge() {
        return upper;
    }

    public List<String> getLowerBridge() {
        return lower;
    }
}
