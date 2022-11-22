package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Results {
    private static final String OPEN_BRACKET = "[ ";

    private final List<RoundResult> results;
    private StringBuilder up;
    private StringBuilder down;

    public Results() {
        this.results = new ArrayList<>();
        this.up = new StringBuilder(OPEN_BRACKET);
        this.down = new StringBuilder(OPEN_BRACKET);
    }

    public List<RoundResult> getResults() {
        return results;
    }

    public void deleteAll() {
        this.results.clear();
        this.up = new StringBuilder(OPEN_BRACKET);
        this.down = new StringBuilder(OPEN_BRACKET);
    }

    public void addCurrentResult(RoundResult roundResult) {
        this.results.add(roundResult);
        Map<String, String> upandDown = roundResult.setUpandDown();
        up.append(upandDown.get("up"));
        down.append(upandDown.get("down"));
    }


    public String getUp() {
        return up.toString();
    }

    public String getDown() {
        return down.toString();
    }

}
