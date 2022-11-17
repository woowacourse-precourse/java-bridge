package bridge.domain;

import bridge.domain.constants.MoveCommands;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatched(Player player, MoveCommands moveCommand) {
        String bridgeCommand = bridge.get(player.position());
        return moveCommand.is(bridgeCommand);
    }
}
