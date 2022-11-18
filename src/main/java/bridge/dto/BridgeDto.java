package bridge.dto;

import bridge.domain.Command;
import bridge.domain.State;

import java.util.List;

public class BridgeDto {
    private List<State> up;
    private List<State> down;

    public BridgeDto(List<State> up, List<State> down) {
        this.up = up;
        this.down = down;
    }

    public List<List<State>> toList() {
        return List.of(up, down);
    }

    public void swap(String upOrDown) {
        if(upOrDown.equals(Command.UP.getAbbreviation())) {
            up.remove(up.size() - 1);
            up.add(State.WRONG);
            return;
        }
        down.remove(down.size()-1);
        down.add(State.WRONG);
    }
}
