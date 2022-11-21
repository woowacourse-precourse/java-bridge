package bridge.dto;

import bridge.domain.Victory;

public class GameResultDto {

    private final Victory victory;
    private final GameMoveDto gameMoveDto;
    private final int count;

    public GameResultDto(Victory victory, GameMoveDto gameMoveDto, int count) {
        this.victory = victory;
        this.gameMoveDto = gameMoveDto;
        this.count = count;
    }

    public Victory getVictory() {
        return victory;
    }

    public GameMoveDto getGameMoveDto() {
        return gameMoveDto;
    }

    public int getCount() {
        return count;
    }
}
