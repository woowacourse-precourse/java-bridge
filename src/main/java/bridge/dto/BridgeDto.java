package bridge.dto;

import bridge.domain.Command;
import bridge.domain.BridgeState;

import java.util.ArrayList;
import java.util.List;

public class BridgeDto {
    private List<BridgeState> up;
    private List<BridgeState> down;

    public BridgeDto() {
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
    }

    public List<List<BridgeState>> toList() {
        return List.of(up, down);
    }

    public void setBridge(Command command, BridgeState state) {
        if (command.equals(Command.UP)) {
            up.add(state);
            down.add(BridgeState.NONE);
            return;
        }
        down.add(state);
        up.add(BridgeState.NONE);
    }
}
