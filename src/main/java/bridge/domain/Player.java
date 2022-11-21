package bridge.domain;

import java.util.List;

public class Player {
    private final List<String> movingInputs;

    public Player(List<String> movingInputs) {
        this.movingInputs = movingInputs;
    }

    public List<String> getMovingInputs() {
        return movingInputs;
    }
}