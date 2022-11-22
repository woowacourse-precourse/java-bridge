package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int nextBridge = -1;
    private List<String> selectedBridge = new ArrayList<>();


    public void chooseDir(String dir) {
        Validator.validateDir(dir);
        selectedBridge.add(dir);
        nextBridge++;
    }

    public void reset() {
        nextBridge = -1;
        selectedBridge = new ArrayList<>();
    }

    public int getNextBridge() {
        return nextBridge;
    }

    public List<String> getSelectedBridge() {
        return selectedBridge;
    }
}
