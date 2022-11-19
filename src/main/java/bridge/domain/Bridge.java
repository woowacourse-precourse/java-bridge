package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public BridgeCrossingStatus isRightTrack(int location, String direction) {
        if (!bridge.get(location).equals(direction)) {
            return BridgeCrossingStatus.FAIL;
        }
        if (location + 1 == bridge.size()) {
            return BridgeCrossingStatus.SUCCESS;
        }
        return BridgeCrossingStatus.PROGRESS;
    }
}
