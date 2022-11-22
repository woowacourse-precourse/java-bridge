package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class OneSideResults {

    private final List<String> results;

    public OneSideResults() {
        results = new ArrayList<>();
    }

    public abstract void update(String playerMove, String matchResult);

    public void reset() {
        results.clear();
    };

    public List<String> getResults() {
        return results;
    }
}
