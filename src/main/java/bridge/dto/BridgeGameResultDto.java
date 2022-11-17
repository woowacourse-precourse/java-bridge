package bridge.dto;

import bridge.domain.Bridge;
import bridge.domain.Visited;

public class BridgeGameResultDto {
    private final int triedCount;
    private final Bridge bridge;
    private final Visited visited;

    public BridgeGameResultDto(int triedCount, Bridge bridge, Visited visited) {
        this.triedCount = triedCount;
        this.bridge = bridge;
        this.visited = visited;
    }

    public int getTriedCount() {
        return triedCount;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public Visited getVisited() {
        return visited;
    }
}
