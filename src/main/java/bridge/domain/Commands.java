package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private final List<String> visited;
    private static int retryCount = 1;

    public Commands() {
        this.visited = new ArrayList<>();
    }

    public void insertCommand(String nextMove) {
        visited.add(nextMove);
    }

    public int lastIndex() {
        return visited.size() - 1;
    }

    public void reset() {
        visited.clear();
    }

    public void retryCountPlus() {
        retryCount++;
    }

    public int size() {
        return visited.size();
    }

    public int getRetryCount() {
        return retryCount;
    }
}
