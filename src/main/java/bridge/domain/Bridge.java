package bridge.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Bridge {
    private final Map<Move, List<String>> bridges;

    public Bridge(Map<Move, List<String>> bridges) {
        this.bridges = bridges;
    }

    public static Bridge from(List<String> bridge) {
        Map<Move, List<String>> bridges = initMap();
        for (String direction : bridge) {
            makeBlock(bridges, direction);
        }

        return new Bridge(bridges);
    }

    public String moveResult(Move move, int distance, String direction) {
        if (move.direction.equals(direction)) {
            return bridges.get(move).get(distance);
        }

        return " ";
    }

    private static void makeBlock(Map<Move, List<String>> bridges, String direction) {
        for (Move move : Move.values()) {
            if (move.direction.equals(direction)) {
                bridges.get(move).add("O");
                continue;
            }
            bridges.get(move).add("X");
        }
    }

    private static Map<Move, List<String>> initMap() {
        Map<Move, List<String>> bridges = new EnumMap<>(Move.class);
        bridges.put(Move.UP, new ArrayList<>());
        bridges.put(Move.DOWN, new ArrayList<>());

        return bridges;
    }
}
