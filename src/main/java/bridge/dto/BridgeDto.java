package bridge.dto;

import bridge.domain.bridge.Bridge;

import java.util.List;

public class BridgeDto {
    private final List<String> bridge;

    private BridgeDto(List<String> bridge) {
        this.bridge = bridge;
    }

    public static BridgeDto from(List<String> bridge) {
        return new BridgeDto(bridge);
    }

    public Bridge toEntity() {
        return Bridge.from(bridge);
    }
}
