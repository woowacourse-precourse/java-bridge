package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayersMove {

    private List<String> playersMove = new ArrayList<>();

    public void move(String choice) {
        playersMove.add(choice);
    }

    public void initialize() {
        playersMove.clear();
    }

    public List<String> getPlayersMove() {
        return playersMove;
    }

    public String getPlayersMoveAtIdx(int moveIdx) {
        return playersMove.get(moveIdx);
    }
}
