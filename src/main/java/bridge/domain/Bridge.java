package bridge.domain;

import bridge.constant.*;

import java.util.*;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatched(Player player, MoveCommand moveCommand) {
        String command = bridge.get(player.position());
        return moveCommand.is(command);
    }

    public boolean isLongerThan(Position position) {
        return position.isLessThan(bridge.size());
    }


}
