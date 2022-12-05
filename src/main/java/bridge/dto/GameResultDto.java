package bridge.dto;

import bridge.domain.BridgeGameCount;
import bridge.domain.GameStatus;

public class GameResultDto {
    private final MovingResultsDto movingResultsDto;
    private final GameStatus gameStatus;
    private final BridgeGameCount bridgeGameCount;

    public GameResultDto(
            MovingResultsDto movingResultsDto,
            GameStatus gameStatus,
            BridgeGameCount bridgeGameCount
    ) {
        this.movingResultsDto = movingResultsDto;
        this.gameStatus = gameStatus;
        this.bridgeGameCount = bridgeGameCount;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public MovingResultsDto getMovingResultsDto() {
        return movingResultsDto;
    }

    public BridgeGameCount getBridgeGameCount() {
        return bridgeGameCount;
    }


}
