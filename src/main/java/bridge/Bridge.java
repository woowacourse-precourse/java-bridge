package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final List<Boolean> results = new ArrayList<>();

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void compareWithBridge(String input) {
        boolean result = bridge.get(results.size()).equals(input);
        results.add(result);
    }


    public List<String> getBridge() {
        return bridge;
    }

    public List<Boolean> getResults() {
        return results;
    }
}
