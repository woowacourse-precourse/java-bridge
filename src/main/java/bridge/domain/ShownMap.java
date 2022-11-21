package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ShownMap {

    private final List<Character> upperMap;
    private final List<Character> lowerMap;

    public ShownMap() {
        this.lowerMap = new ArrayList<>();
        this.upperMap = new ArrayList<>();
    }

    public List<List<Character>> getShownMap() {
        return List.of(upperMap, lowerMap);
    }

    public void clear() {
        upperMap.clear();
        lowerMap.clear();
    }

    public void addUpper(char result) {
        upperMap.add(result);
    }

    public void addLower(char result) {
        lowerMap.add(result);
    }
}
