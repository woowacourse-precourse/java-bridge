package bridge.domain;

import java.util.List;

public class Player {
    private List<String> movingInputs;

    public Player(List<String> movingInputs) {
        this.movingInputs = movingInputs;
    }

    public List<String> getMovingInputs() {
        return movingInputs;
    }

    public String informMoving() {
        return movingInputs.get(movingInputs.size() - 1);
    }

    public int informMovingIndex() {
        return movingInputs.size() - 1;
    }
}