package bridge.dto;

import bridge.domain.BridgeGameCount;
import bridge.domain.GameStatus;

public class GameResultDto {
    private final MovingResultsDto movingResultsDto;
    private final String gameStatus;
    private final int bridgeGameCount;

    public GameResultDto(
            MovingResultsDto movingResultsDto,
            GameStatus gameStatus,
            BridgeGameCount bridgeGameCount
    ) {
        this.movingResultsDto = movingResultsDto;
        this.gameStatus = gameStatus.getStatus();
        this.bridgeGameCount = bridgeGameCount.getCount();
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public MovingResultsDto getMovingResultsDto() {
        return movingResultsDto;
    }

    public int getBridgeGameCount() {
        return bridgeGameCount;
    }
}
