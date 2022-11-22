package bridge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PresentBridgeMaker {

    private HashMap<String, List<String>> presentBridge;

    public void initPresentBridge() {
        this.presentBridge = new HashMap<>();
        this.presentBridge.put("U", new ArrayList<>());
        this.presentBridge.put("D", new ArrayList<>());
    }

    public HashMap<String, List<String>> getPresentBridge() {
        return this.presentBridge;
    }

    public void setPresentBridge(HashMap<String, List<String>> presentBridge) {
        this.presentBridge = presentBridge;
    }
}
