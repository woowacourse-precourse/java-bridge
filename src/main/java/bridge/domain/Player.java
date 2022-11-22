package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Player {
    private final List<String> movingChoices;

    public Player(List<String> movingChoices) {
        this.movingChoices = movingChoices;
    }

    public List<String> getMovingChoices() {
        return Collections.unmodifiableList(movingChoices);
    }
}