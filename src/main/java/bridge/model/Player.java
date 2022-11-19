package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> directions = new ArrayList<>();
    private int attempt = 1;

    public void attempt() {
        attempt += 1;
        directions.clear();
    }

    public void move(Direction direction) {
        directions.add(direction.getDirection());
    }

    public int getAttempt() {
        return attempt;
    }

    public List<String> getDirections() {
        return new ArrayList<>(directions);
    }

}
