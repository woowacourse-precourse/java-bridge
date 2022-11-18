package bridge.dto;

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
}
