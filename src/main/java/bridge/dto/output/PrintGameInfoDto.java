package bridge.dto.output;

import bridge.domain.game.Bridge;
import bridge.domain.player.Player;
import bridge.dto.controller.ExitDto;

public class PrintGameInfoDto {

    private final long tryCount;
    private final boolean success;

    public PrintGameInfoDto(final ExitDto exitDto) {
        Player player = exitDto.getPlayer();
        Bridge bridge = exitDto.getBridge();

        this.tryCount = player.getTryCount();
        this.success = player.isSuccessful(bridge);
    }

    public long getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return success;
    }
}
