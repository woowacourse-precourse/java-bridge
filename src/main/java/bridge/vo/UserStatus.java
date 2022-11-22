package bridge.vo;

import java.util.ArrayList;
import java.util.List;

public class UserStatus {

    private List<String> currentCrossedBridge;

    public UserStatus() {
        currentCrossedBridge = new ArrayList<>();
    }

    public List<String> getCurrentCrossedBridge() {
        return new ArrayList<>(currentCrossedBridge);
    }

    public void addCrossedHistory(String c) {
        currentCrossedBridge.add(c);
    }

    public int getCurrentIndex() {
        return currentCrossedBridge.size() - 1;
    }

    public String getCurrentPosition() {
        return currentCrossedBridge.get(getCurrentIndex());
    }

    public void clear() {
        currentCrossedBridge = new ArrayList<>();
    }
}
