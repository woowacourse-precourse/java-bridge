package bridge.dto.controller;

import bridge.domain.player.Player;
import bridge.utils.game.GameStatus;

public class MoveDto {

    private final GameStatus nextGameStatus;
    private final Player player;

    public MoveDto(final GameStatus nextGameStatus, final Player player) {
        this.nextGameStatus = nextGameStatus;
        this.player = player;
    }

    public GameStatus getNextGameStatus() {
        return nextGameStatus;
    }

    public Player getPlayer() {
        return player;
    }
}
