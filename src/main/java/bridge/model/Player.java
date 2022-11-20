package bridge.model;

import bridge.util.Rules;

import java.util.List;

public class Player {
    private PlayerPath playerPath;
    private int gameTryCount = 0;

    public Player() {
        newTry();
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

    public void nextStep(Plate nextPlate) {
        playerPath.nextStep(nextPlate);
    }

    public void newTry() {
        playerPath = new PlayerPath();
        gameTryCount = gameTryCount + 1;
    }
}
