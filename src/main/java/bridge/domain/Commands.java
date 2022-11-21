package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private static List<String> visited = new ArrayList<>();
    private static int retryCount = 1;

    private static final Commands instance = new Commands();

    public static Commands getInstance() {
        return instance;
    }

    private Commands() {

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
