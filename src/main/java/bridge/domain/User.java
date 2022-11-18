package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String > position = new ArrayList<>();
    private Integer retry = 0;

    public Integer getRetry() {
        return retry;
    }

    public void move(String currentPosition) {
        position.add(currentPosition);
    }

    public void resetPosition() {
        position.clear();
        retry++;
    }

    @Override
    public String toString() {
        return null;
    }
}
