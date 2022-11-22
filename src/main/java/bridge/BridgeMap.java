package bridge;

import java.util.List;

public class BridgeMap {

    private final Character[][] map;

    BridgeMap(Bridge bridge, List<Direction> histories) {
        this.map = makeMap(bridge, histories);
    }

    public Character[][] makeMap(Bridge bridge, List<Direction> histories) {
        Character[][] map = initializeMap(histories);
        for (int i = 0; i < histories.size(); i++) {
            Direction currHistory = histories.get(i);
            map[currHistory.getIndex()][i] = ResultFormat
                    .convertToResultType(bridge.canMoveTo(currHistory, i))
                    .getResultAlphabet();
        }
        return map;
    }

    public Character[][] initializeMap(List<Direction> histories) {
        Character[][] map = new Character[Direction.getSize()][histories.size()];
        for (int i = 0; i < Direction.getSize(); i++) {
            for (int j = 0; j < histories.size(); j++) {
                map[i][j] = ' ';
            }
        }
        return map;
    }


}
