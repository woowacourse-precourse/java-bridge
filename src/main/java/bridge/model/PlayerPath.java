package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerPath {
    private final List<Tile> playerPath;

    public PlayerPath() {
        playerPath = new ArrayList<>();
    }

    public List<Tile> getPlayerPath() {
        return playerPath;
    }

    public void nextStep(Tile nextTile) {
        playerPath.add(nextTile);
    }

    public int currentPosition() {
        return (playerPath.size() - 1);
    }

    public Tile currentTile() {
        if (playerPath.size() == 0) {
            return null;
        }
        return playerPath.get(currentPosition());
    }
}
