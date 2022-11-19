package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridges;

    public Bridge(List<String> bridges) {
        this.bridges = bridges;
    }

    public String moveResult(Move move, int distance, String direction) {
        if (move.direction.equals(direction)) {
            if (bridges.get(distance).equals(direction)) {
                return "O";
            }
            return "X";
        }
        return " ";
    }

    @Override
    public String toString() {
        return bridges.toString();
    }
}
