package bridge.dto;

import java.util.List;

public class BridgeRouteDto {

    private final List<String> bridge;

    private final List<String> moveHistory;

    public BridgeRouteDto(List<String> bridge, List<String> moveHistory) {
        this.bridge = bridge;
        this.moveHistory = moveHistory;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMoveHistory() {
        return moveHistory;
    }
}
