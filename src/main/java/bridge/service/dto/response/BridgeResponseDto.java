package bridge.service.dto.response;

import bridge.domain.BridgeStatus;

public class BridgeResponseDto {
    private final BridgeStatus bridgeStatus;

    public BridgeResponseDto(BridgeStatus bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    public BridgeStatus getBridgeStatus() {
        return this.bridgeStatus;
    }
}
