package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> movingSpaces;
    private boolean isPossible;
    private int attempt;

    public Player() {
        this.movingSpaces = new ArrayList<>();
        this.isPossible = true;
        this.attempt = 1;
    }

    public void addMovingSpaces(String movingSpace) {
        movingSpaces.add(movingSpace);
    }

    public void resetPlayer() {
        movingSpaces.clear();
        isPossible = true;
    }

    public void addAttempt() {
        this.attempt++;
    }

    public void playerIsFail() {
        this.isPossible = false;
    }

    public int getMovingSpacesSize() {
        return movingSpaces.size();
    }

    public List<String> getMovingSpaces() {
        return movingSpaces;
    }

    public boolean isPossible() {
        return isPossible;
    }

    public int getAttempt() {
        return attempt;
    }
}
