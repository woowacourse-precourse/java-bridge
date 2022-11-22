package bridge.domain;

import java.util.List;

public class BridgeMap {

    private final Character[][] map;

    public BridgeMap(Bridge bridge, List<Direction> histories) {
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


    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for (Character[] characters : map) {
            StringBuilder oneLine = toString(characters);
            resultString.append("[").append(removeEnd(oneLine)).append("]\n");
        }
        return resultString.toString();
    }

    public StringBuilder toString(Character[] characters) {
        StringBuilder resultString = new StringBuilder();
        for (Character character : characters) {
            resultString.append(" ").append(character).append(" |");
        }
        return resultString;
    }

    public String removeEnd(StringBuilder resultString) {
        return resultString.substring(0, resultString.length() - 1);
    }


}
