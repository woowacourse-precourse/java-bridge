package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> playerMoveList;

    public Player() {
        playerMoveList = new ArrayList<>();
    }

    public List<String> getPlayerMoveList() {
        return playerMoveList;
    }

    public void move(String moveCommand) {
        playerMoveList.add(moveCommand);
    }
}
