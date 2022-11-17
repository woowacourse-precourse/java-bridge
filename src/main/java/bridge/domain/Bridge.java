package bridge.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(List<String> userMoved, int idx) {
        return bridge.get(idx) == userMoved.get(idx);
    }

    public Map<String, String> getMatchingStatus(List<String> userMoved) {
        Map<String, String> matchingStatus = new LinkedHashMap<>();
        for (int i = 0; i < userMoved.size(); i++) {
            if (canMove(userMoved, i)) {
                matchingStatus.put(userMoved.get(i), "O");
                continue;
            }
            matchingStatus.put(userMoved.get(i), "X");
        }
        return matchingStatus;
    }
}
