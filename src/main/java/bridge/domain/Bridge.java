package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridgeInfo) {
        this.bridge = bridgeInfo;
    }

    public List<Boolean> compareWithUserMovement(List<String> userMovement) {
        List<Boolean> compareResult = new ArrayList<>();
        for (int i = 0; i < userMovement.size(); i++) {
            compareResult.add(userMovement.get(i).equals(bridge.get(i)));
        }
        return compareResult;
    }

    public Boolean atTheEndOfBridge(List<String> userMovement) {
        return userMovement.size() == bridge.size();
    }
}
