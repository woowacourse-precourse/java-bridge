package bridge.dto;

import bridge.domain.Bridge;
import bridge.domain.Visited;

public class BridgeGameResultDto {
    private static final String SMALLER_THAN_ONE_MESSAGE = "시도 횟수는 1이상이어야 합니다";
    private static final String BRIDGE_NOT_NULL_MESSAGE = "bridge 에는 null 이 들어올 수 없습니다";
    private static final String VISITED_NOT_NULL_MESSAGE = "visited 에는 null 이 들어올 수 없습니다";
    private final int triedCount;
    private final Bridge bridge;
    private final Visited visited;

    public BridgeGameResultDto(int triedCount, Bridge bridge, Visited visited) {
        validateTriedCount(triedCount);
        validateBridge(bridge);
        validateVisited(visited);
        this.triedCount = triedCount;
        this.bridge = bridge;
        this.visited = visited;
    }

    private void validateTriedCount(int triedCount) {
        if (triedCount < 1) {
            throw new IllegalArgumentException(SMALLER_THAN_ONE_MESSAGE);
        }
    }

    private void validateBridge(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(BRIDGE_NOT_NULL_MESSAGE);
        }
    }

    private void validateVisited(Visited visited) {
        if (visited == null) {
            throw new IllegalArgumentException(VISITED_NOT_NULL_MESSAGE);
        }
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
