package bridge.model;

import static java.util.stream.Collectors.toList;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.List;

public class Bridges {
    private final List<Position> positions;

    Bridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        List<String> bridges = this.getBridges(size, bridgeNumberGenerator);
        this.positions = this.getPositionTypes(bridges);
    }

    private List<String> getBridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }

    private List<Position> getPositionTypes(List<String> bridges) {
        return bridges.stream()
                .map(Position::create)
                .collect(toList());
    }

    boolean isCompletedGame(Player player) {
        return player.isCompletedGame(this.getSize());
    }

    private int getSize() {
        return this.positions.size();
    }

    boolean isSuccess(Player player) {
        return player.isSuccess(this.getPositions());
    }

    private List<Position> getPositions() {
        return List.copyOf(this.positions);
    }
}
