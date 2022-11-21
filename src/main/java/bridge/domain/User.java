package bridge.domain;

import java.util.List;

public class User {
    private final int restartCount;
    private final List<String> userBridge;

    public User(int restartCount, List<String> userBridge) {
        this.restartCount = restartCount;
        this.userBridge = userBridge;
    }

    

    public int getRestartCount() {
        return restartCount;
    }

    public List<String> getUserBridge() {
        return userBridge;
    }
}
