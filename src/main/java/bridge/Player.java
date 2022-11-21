package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> footprints;

    public Player() {
        this.footprints = new ArrayList<>();
    }

    public void move(String movedSide) {
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
