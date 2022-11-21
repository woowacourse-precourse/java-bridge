package bridge.dto;

import bridge.domain.game.GameStatus;

public class ResultDto {

    private final String status;
    private final int attempts;
    private final MapDto mapDto;

    public ResultDto(GameStatus status, int attempts, MapDto mapDto) {
        this.status = status.getStatus();
        this.attempts = attempts;
        this.mapDto = mapDto;
    }

    public String getStatus() {
        return status;
    }

    public int getAttempts() {
        return attempts;
    }

    public MapDto getMapDto() {
        return mapDto;
    }
}
