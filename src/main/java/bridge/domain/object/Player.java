package bridge.domain.object;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> moves = new ArrayList<>();

    public void addMove(final String move) {
        moves.add(move);
    }

    public List<String> getMoves() {
        return moves;
    }
}
