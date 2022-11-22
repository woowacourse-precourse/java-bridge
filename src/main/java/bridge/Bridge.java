package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridgeComponent;
    private final String UP = "U";
    private final String DOWN = "D";

    public Bridge(List<String> bridgeComponent) {
        validBridge(bridgeComponent);
        this.bridgeComponent = bridgeComponent;
    }

    private void validBridge(List<String> bridge) {
        validateBridgeNotNull(bridge);
        validateBridgeLength(bridge);
        validateBridgeComponent(bridge);
    }

    private void validateBridgeNotNull(List<String> bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException("다리는 NULL일 수 없습니다.");
        }
    }

    private void validateBridgeLength(List<String> bridge) {
        if (bridge.size() < 3 || bridge.size() > 20) {
            throw new IllegalArgumentException("다리 길이는 3 ~ 20이어야 합니다.");
        }
    }

    private void validateBridgeComponent(List<String> bridge) {
        for (String component : bridge) {
            if (!component.equals(UP) && !component.equals(DOWN)) {
                throw new IllegalArgumentException("다리 요소는 U,D 어야 합니다.");
            }
        }
    }

    public List<String> getBridgeComponent() {
        return bridgeComponent;
    }

    public int getBridgeLength() {
        return bridgeComponent.size();
    }
}
