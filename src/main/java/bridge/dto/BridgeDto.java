package bridge.dto;

import bridge.domain.Command;
import bridge.domain.State;

import java.util.ArrayList;
import java.util.List;

public class BridgeDto {
    private List<State> up;
    private List<State> down;

    public BridgeDto() {
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
    }

    public List<List<State>> toList() {
        return List.of(up, down);
    }

    public void setBridge(Command command, State state) {
        if (command.equals(Command.UP)) {
            up.add(state);
            down.add(State.NONE);
            return;
        }
        down.add(state);
        up.add(State.NONE);
    }
}
