package bridge.service.dto.response;

import bridge.domain.BridgeStatus;
import bridge.domain.Player;
import bridge.domain.Result;

import java.util.List;

public class GameResultResponseDto {
    private final BridgeStatus bridgeStatus;
    private final String gameSuccessOrFail;
    private final int totalTryNumber;

    public GameResultResponseDto(Result result, Player player) {
        this.bridgeStatus = result.getBridgeStatus();
        this.gameSuccessOrFail = result.getGameOver().getName();
        this.totalTryNumber = player.getTotalTryNumber();
    }

    public BridgeStatus getBridgeStatus() {
        return bridgeStatus;
    }

    public String getGameSuccessOrFail() {
        return gameSuccessOrFail;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }
}
