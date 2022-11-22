package bridge.domain;

import bridge.constant.MoveCommand;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatched(Player player, MoveCommand moveCommand) {
        String command = bridge.get(player.position());
        return moveCommand.equals(command);
    }

    public boolean isLongerThan(Position position) {
        return position.isLessThan(bridge.size());
    }


}
