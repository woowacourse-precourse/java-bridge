package bridge.service.dto.response;

import bridge.domain.BridgeStatus;
import bridge.domain.Player;

public class GameResultResponseDto {
    private final BridgeStatus bridgeStatus;
    private final String result;
    private final int totalTryNumber;

    public GameResultResponseDto(BridgeStatus bridgeStatus, Player player) {
        this.bridgeStatus = bridgeStatus;
        this.result = player.getResult().getName();
        this.totalTryNumber = player.getTotalTryNumber();
    }

    public BridgeStatus getBridgeStatus() {
        return bridgeStatus;
    }

    public String getGameSuccessOrFail() {
        return result;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }
}
