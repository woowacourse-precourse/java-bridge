package bridge.model;

import bridge.util.Rules;

import java.util.List;

public class Player {
    private PlayerPath playerPath;
    private int gameTryCount;
    private boolean isVictory = false;

    public Player() {
        playerPath = new PlayerPath();
        gameTryCount = 0;
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

    public boolean isVictory() {
        return isVictory;
    }

    public void nextStep(Plate nextPlate) {
        playerPath.nextStep(nextPlate);
    }

    public void newTry() {
        playerPath = new PlayerPath();
        gameTryCount = gameTryCount + 1;
    }

    public void victory() {
        isVictory = true;
    }
}
