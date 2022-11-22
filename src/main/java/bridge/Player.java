package bridge;

import exceptionHandler.SideSelectionException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> footprints;

    public Player(List<String> footprints) {
        this.footprints = footprints;
    }

    public void move(String movingSide) {
        validate(movingSide);
        footprints.add(movingSide);
    }

    public int getCurrentPosition() {
        return this.footprints.size() - 1;
    }

    public void initializePosition() {
        this.footprints = new ArrayList<>();
    }

    public String getLastMoving() {
        return footprints.get(getCurrentPosition());
    }

    private void validate(String movableSide) {
        SideSelectionException.validate(movableSide);
    }
}