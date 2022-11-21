package bridge.domain;

import bridge.utils.constants.Comments;
import bridge.utils.constants.Commons;
import bridge.utils.constants.ErrorMessages;
import java.util.List;

public class Bridge {

    List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    private void validate(List<String> bridge) {
        if (isNotValidBridge(bridge)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE.getMessage());
        }
        if (isNotValidBridgeSize(bridge)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    private boolean isNotValidBridgeSize(List<String> bridge) {
        return !(bridge.size() >= Commons.MIN_BRIDGE_RANGE.getNumber()
                && bridge.size() <= Commons.MAX_BRIDGE_RANGE.getNumber());
    }

    private static boolean isNotValidBridge(List<String> bridge) {
        return !(bridge.stream()
                .allMatch((val) -> Comments.UP.getComment().equals(val) || Comments.DOWN.getComment().equals(val)));
    }


}
