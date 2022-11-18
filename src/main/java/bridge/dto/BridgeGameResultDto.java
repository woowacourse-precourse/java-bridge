package bridge.dto;

import bridge.domain.GameResult;

public final class BridgeGameResultDto {
    private static final String SMALLER_THAN_ONE_MESSAGE = "시도 횟수는 1이상이어야 합니다";
    private static final String LOG_NOT_NULL_MESSAGE = "playLog 에는 null 이 들어올 수 없습니다";
    private static final String GAME_RESULT_NOT_NULL_MESSAGE = "gameResult 에는 null 이 들어올 수 없습니다";
    private final int triedCount;
    private final PlayLogDto logDto;
    private final GameResult gameResult;

    public BridgeGameResultDto(int triedCount, PlayLogDto logDto, GameResult gameResult) {
        validateTriedCount(triedCount);
        validatePlayLogDto(logDto);
        validateGameResult(gameResult);
        this.triedCount = triedCount;
        this.logDto = logDto;
        this.gameResult = gameResult;
    }


    private void validateTriedCount(int triedCount) {
        if (triedCount < 1) {
            throw new IllegalArgumentException(SMALLER_THAN_ONE_MESSAGE);
        }
    }

    private void validatePlayLogDto(PlayLogDto playLogDto) {
        if (playLogDto == null) {
            throw new IllegalArgumentException(LOG_NOT_NULL_MESSAGE);
        }
    }

    private void validateGameResult(GameResult gameResult) {
        if (gameResult == null) {
            throw new IllegalArgumentException(GAME_RESULT_NOT_NULL_MESSAGE);
        }
    }

    public int getTriedCount() {
        return triedCount;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public PlayLogDto getLog() {
        return logDto;
    }
}
