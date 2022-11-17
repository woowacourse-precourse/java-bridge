package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<String> moves;

    public Player() {
        moves = new ArrayList<>();
    }

    public void move(GameMove move) {
        this.moves.add(move.getLetter());
    }
}
