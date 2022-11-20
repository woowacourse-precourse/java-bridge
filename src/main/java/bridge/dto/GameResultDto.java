package bridge.dto;

import bridge.domain.Victory;

public class GameResultDto {

    private final Victory victory;
    private final GameMoveDto result;
    private final int count;

    public GameResultDto(Victory victory, GameMoveDto result, int count) {
        this.victory = victory;
        this.result = result;
        this.count = count;
    }

    public Victory getVictory() {
        return victory;
    }

    public GameMoveDto getResult() {
        return result;
    }

    public int getCount() {
        return count;
    }
}
