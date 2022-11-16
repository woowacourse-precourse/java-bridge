package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {

    private final List<String> upResults = new ArrayList<>();
    private final List<String> downResults = new ArrayList<>();

    public void addResults(String movement, String matchResult) {
        if (movement.equals("U")) {
            upResults.add(matchResult);
            downResults.add(" ");
            return;
        }

        upResults.add(" ");
        downResults.add(matchResult);
    }

    public void reset() {
        upResults.clear();
        downResults.clear();
    }

    public List<String> upResults() {
        return Collections.unmodifiableList(upResults);
    }

    public List<String> downResults() {
        return Collections.unmodifiableList(downResults);
    }
}
