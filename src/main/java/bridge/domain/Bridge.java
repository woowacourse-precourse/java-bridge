package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> status;

    public Bridge(List<String> status) {
        this.status = status;
    }

    public Boolean isMoveable(String userMovement, int bridgePosition) {
        return status.get(bridgePosition).equals(userMovement);
    }
}
