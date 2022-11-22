package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final PositionTable bridgeTable;

    private Bridge(List<String> bridge) throws IllegalStateException {
        this.bridgeTable = mapToPositionTable(bridge);
    }

    private static PositionTable mapToPositionTable(List<String> bridge) throws IllegalStateException {
        PositionTable positionTable = PositionTable.newInstance();
        bridge.stream().map(s -> Position.of(s)).forEach(positionTable::add);
        return positionTable;
    }

    public static Bridge of(List<String> generatedBridge) throws IllegalStateException {
        return new Bridge(generatedBridge);
    }

    public static Bridge makeBridge(int bridgeSize) throws IllegalArgumentException, IllegalStateException {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return of(bridgeMaker.makeBridge(bridgeSize));
    }

    public GameResult play(PositionTable userTable) {
        if (bridgeTable.equals(userTable)) {
            return GameResult.WIN;
        }
        if (bridgeTable.matchLastOf(userTable)) {
            return GameResult.KEEP;
        }
        return GameResult.LOSE;
    }

    public int size() {
        return bridgeTable.size();
    }
}

