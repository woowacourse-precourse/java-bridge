package bridge.domain;

import java.util.ArrayList;
import java.util.List;


public class UserBridge {

    private List<String> userBridge;

    public UserBridge() {
        userBridge = new ArrayList<>();
    }

    public int getCurrentIndex() {
        if (userBridge.size() != 0) {
            return userBridge.size() - 1;
        }
        return 0;
    }

    public void add(String position) {
        userBridge.add(position);
    }

    public void initialize() {
        userBridge.clear();
    }

    public boolean isArrive(Bridge bridge) {
        return bridge.isSame(userBridge);
    }

}
