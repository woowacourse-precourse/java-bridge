package bridge;

import exceptionHandler.BridgeGenerationException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> footprints;

    public Player(List<String> footprints) {
        this.footprints = footprints;
    }

    private void validate(String movableSide) {
        BridgeGenerationException.validate(movableSide);
    }

    public void move(String movedSide) {
        validate(movedSide);
        footprints.add(movedSide);
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
}
