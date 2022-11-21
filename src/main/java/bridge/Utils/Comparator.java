package bridge.Utils;

import java.util.List;

public class Comparator {
    private int tryCount;
    private int location;

    public Comparator() {
        this.tryCount = 1;
        this.location = 0;
    }

    public void addTryCount() {
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isPassable(List<String> bridge) {
        return bridge.size() > location;
    }

    public boolean passBlockAndResult(List<String> bridge, String direction) {
        if (bridge.get(location).equals(direction)) {
            location++;
            return true;
        }
        return false;
    }

    public List<String> getPassedBridge(List<String> bridge) {
        return bridge.subList(0, location);
    }

}
