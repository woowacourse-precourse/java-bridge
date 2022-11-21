package bridge.model;

import bridge.util.Rules;

import java.util.List;

public class Player {
    private PlayerPath playerPath;
    private int gameTryCount;

    public Player() {
        playerPath = new PlayerPath();
        gameTryCount = 1;
    }

    public int getPlayerPosition() {
        return playerPath.currentPosition();
    }

    public Plate getCurrentPlate() {
        return playerPath.currentPlate();
    }

    public List<Plate> getPlayerPath() {
        return playerPath.getPlayerPath();
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public void nextStep(Plate nextPlate) {
        playerPath.nextStep(nextPlate);
    }

    public void newTry() {
        playerPath = new PlayerPath();
        gameTryCount = gameTryCount + 1;
    }
}
