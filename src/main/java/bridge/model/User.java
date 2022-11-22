package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<String> moves = new ArrayList<>();

    public void addMove(String move) {
        moves.add(move);
    }

    public int getMoveCount() {
        return moves.size();
    }
}
