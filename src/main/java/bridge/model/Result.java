package bridge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<List<String>> resultBridges = new ArrayList<>();
    private final Map<Boolean, String> ox = new HashMap<>();
    private int tryCount = 1;
    private boolean success = true;

    public Result() {
        ox.put(true, "O");
        ox.put(false, "X");
    }
}
