package bridge.domain;

import java.util.List;

public class Player {
    private List<String> movingInputs;

    public Player(List<String> movingInputs) {
        this.movingInputs = movingInputs;
    }

    public String informMoving() {
        return movingInputs.get(movingInputs.size() - 1);
    }
}