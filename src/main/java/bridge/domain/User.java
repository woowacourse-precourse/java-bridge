package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<String> topBridge;
    public List<String> bottomBridge;

    public User() {
        this.topBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }
}