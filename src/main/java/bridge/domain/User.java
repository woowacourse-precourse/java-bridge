package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final List<String> moveHistory = new ArrayList<>();
    private Integer tryCount = 1;

    public List<String> getMoveHistory() {
        return Collections.unmodifiableList(moveHistory);
    }

    public Integer getStep() {
        return moveHistory.size();
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void stepForward(String direction) {
        moveHistory.add(direction);
    }

    public void stepInit() {
        moveHistory.clear();
    }

    public void increaseRetryCount() {
        tryCount++;
    }
}
