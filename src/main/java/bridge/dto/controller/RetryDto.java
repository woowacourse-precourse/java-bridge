package bridge.dto.controller;

import bridge.utils.game.GameStatus;

public class RetryDto {

    private final GameStatus nextGameStatus;

    public RetryDto(final GameStatus nextGameStatus) {
        this.nextGameStatus = nextGameStatus;
    }

    public GameStatus getNextGameStatus() {
        return nextGameStatus;
    }
}
