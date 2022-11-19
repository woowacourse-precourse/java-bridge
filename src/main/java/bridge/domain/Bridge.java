package bridge.domain;

import bridge.domain.constants.MoveCommands;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(final List<String> bridge) {
        this.bridge = bridge;
    }

    boolean isMatched(final Player player, final MoveCommands moveCommand) {
        String bridgeCommand = bridge.get(player.position());
        return moveCommand.is(bridgeCommand);
    }

    boolean isLongerThan(Position position) {
        return position.isLessThan(bridge.size());
    }
}
