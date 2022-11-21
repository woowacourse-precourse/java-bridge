package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> movingSpaces;
    private boolean isSuccess;
    private int attempt;

    public Player() {
        this.movingSpaces = new ArrayList<>();
        this.isSuccess = false;
        this.attempt = 1;
    }

    public void addMovingSpaces(String movingSpace) {
        movingSpaces.add(movingSpace);
    }

    public void clearMovingSpaces() {
        movingSpaces.clear();
    }

    public void addAttempt() {
        this.attempt++;
    }

    public void playerIsSuccess() {
        this.isSuccess = true;
    }

    public int getMovingSpacesSize() {
        return movingSpaces.size();
    }

    public List<String> getMovingSpaces() {
        return movingSpaces;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getAttempt() {
        return attempt;
    }
}
