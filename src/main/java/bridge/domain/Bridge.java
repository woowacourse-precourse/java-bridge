package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(List<String> userMoved, int idx) {
        return bridge.get(idx) == userMoved.get(idx);
    }

    public List<String> getMatchingStatus(List<String> userMoved) {
        List<String> matchingStatus = new ArrayList<>();
        for (int i = 0; i < userMoved.size(); i++) {
            if (canMove(userMoved, i)) {
                matchingStatus.add("O");
                continue;
            }
            matchingStatus.add("X");
        }
        return matchingStatus;
    }
}
