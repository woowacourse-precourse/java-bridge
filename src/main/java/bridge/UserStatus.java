package bridge;

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

}
