package bridge.service.dto.response;

import bridge.domain.BridgeStatus;
import bridge.domain.Result;

public class BridgeResponseDto {
    private final BridgeStatus bridgeStatus;

    public BridgeResponseDto(Result result) {
        this.bridgeStatus = result.getBridgeStatus();
    }

    public BridgeStatus getBridgeStatus() {
        return this.bridgeStatus;
    }
}
