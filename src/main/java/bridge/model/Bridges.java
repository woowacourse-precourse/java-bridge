package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridges {
    private final List<Position> positions;

    Bridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        List<String> bridges = getBridges(size, bridgeNumberGenerator);
        positions = getPositionTypes(bridges);
    }

    private static List<String> getBridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }

    private List<Position> getPositionTypes(List<String> bridges) {
        return bridges.stream()
                .map(Position::create)
                .collect(Collectors.toList());
    }

    boolean isCompletedGame(Player player) {
        return player.isCompletedGame(positions.size());
    }

    boolean isSuccess(Player player) {
        return player.isSuccess(getPositions());
    }

    private List<Position> getPositions() {
        return List.copyOf(positions);
    }
}
