package bridge.dto.controller;

import bridge.domain.game.Bridge;
import bridge.domain.player.Player;

public class ExitDto {

    private final Player player;
    private final Bridge bridge;

    public ExitDto(final Player player, final Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
    }

    public Player getPlayer() {
        return player;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
