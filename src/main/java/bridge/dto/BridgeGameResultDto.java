package bridge.dto;

import bridge.domain.BridgeGameResult;

public class BridgeGameResultDto {
    private static final String SMALLER_THAN_ONE_MESSAGE = "시도 횟수는 1이상이어야 합니다";
    private static final String IS_NOT_NULL = "playLog 에는 null 이 들어올 수 없습니다";
    private final int triedCount;
    private final BridgeGameLocationDto bridgeGameLocationDto;
    private final BridgeGameResult gameResult;

    private BridgeGameResultDto(final int triedCount, final BridgeGameLocationDto bridgeGameLocationDto, final BridgeGameResult gameResult) {
        validateTriedCount(triedCount);
        validateLogDto(bridgeGameLocationDto);
        validateGameResult(gameResult);
        this.triedCount = triedCount;
        this.bridgeGameLocationDto = bridgeGameLocationDto;
        this.gameResult = gameResult;
    }
    public static BridgeGameResultDto of (final int triedCount, final BridgeGameLocationDto bridgeGameLocationDto, final BridgeGameResult gameResult){
        return new BridgeGameResultDto(triedCount, bridgeGameLocationDto, gameResult);
    }


    private void validateTriedCount(final int triedCount) {
        if (triedCount < 1) {
            throw new IllegalArgumentException(SMALLER_THAN_ONE_MESSAGE);
        }
    }

    private void validateLogDto(final BridgeGameLocationDto bridgeGameLocationDto) {
        if (bridgeGameLocationDto == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }

    private void validateGameResult(final BridgeGameResult gameResult) {
        if (gameResult == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }

    public int getTriedCount() {
        return triedCount;
    }

    public BridgeGameResult getGameResult() {
        return gameResult;
    }

    public BridgeGameLocationDto getLog() {
        return bridgeGameLocationDto;
    }
}
