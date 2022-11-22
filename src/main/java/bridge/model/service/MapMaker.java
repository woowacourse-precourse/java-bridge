package bridge.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMaker {
    private Map<String, List<String>> results;
    private List<String> upResults;
    private List<String> downResults;

    public MapMaker() {
        results = new HashMap<>();
        this.upResults = new ArrayList<>();
        this. downResults = new ArrayList<>();

        results.put("up", upResults);
        results.put("down", downResults);
    }

    public void insertUpResult(String moveResult) {
        results.get("up").add(moveResult);
    }

    public void insertDownResult(String moveResult) {
        results.get("down").add(moveResult);
    }

    public Map<String, List<String>> getResults() {
        return results;
    }
}
