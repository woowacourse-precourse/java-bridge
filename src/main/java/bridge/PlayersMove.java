package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayersMove {

    private List<String> playersMove = new ArrayList<>();

    public void move(String choice) {
        playersMove.add(choice);
    }

    public void backtrack() {
        playersMove.remove(playersMove.size() - 1);
    }

    public void initialize() {
        playersMove.clear();
    }
}
