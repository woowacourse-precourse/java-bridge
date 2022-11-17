package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeModel {

    private List<List<String>> currentMap;
    private int numberOfAttempts;
    private String outcome;

    public BridgeModel() {
        currentMap = new ArrayList<>();
        numberOfAttempts = 1;
        outcome = "";
    }

    protected List<List<String>> saveCurrentMap(String mapPosition) {
        this.currentMap.add(Arrays.asList(mapPosition.split("-")));
        return currentMap;
    }

}
