package bridge.domain;

import java.util.List;

public class Bridge {
    private final PositionTable bridgeTable;

    private Bridge(List<String> bridge) {
        this.bridgeTable = mapToPositionTable(bridge);
    }

    private static PositionTable mapToPositionTable(List<String> bridge) {
        PositionTable positionTable = PositionTable.newInstance();
        bridge.stream().map(s -> Position.of(s)).forEach(positionTable::add);
        return positionTable;
    }

    public static Bridge of(List<String> generatedBridge) {
        return new Bridge(generatedBridge);
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

