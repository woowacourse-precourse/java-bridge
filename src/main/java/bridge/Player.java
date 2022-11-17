package bridge;

import bridge.type.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private int tryCount = 0;
    
    private List<String> bridge;
    private List<String> moveHistory = new ArrayList<>();

    public void move(String direction) {
        moveHistory.add(direction);
    }
    
    public void addBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getMoveHistory() {
        return Collections.unmodifiableList(moveHistory);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}
