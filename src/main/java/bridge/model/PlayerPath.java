package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerPath {
    private final List<Plate> playerPath;

    public PlayerPath() {
        playerPath = new ArrayList<>();
    }

    public List<Plate> getPlayerPath() {
        return playerPath;
    }

    public void nextStep(Plate nextPlate) {
        playerPath.add(nextPlate);
    }

    public int currentPosition() {
        return (playerPath.size() - 1);
    }

    public Plate currentPlate() {
        if (playerPath.size() == 0) {
            return null;
        }
        return playerPath.get(currentPosition());
    }
}
