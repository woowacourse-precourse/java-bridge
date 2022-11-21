package bridge.domain.object;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<String> moves = new ArrayList<>();

    public void addMove(String move) {
        moves.add(move);
    }

    public List<String> getMoves() {
        return moves;
    }
}
