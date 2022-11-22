package bridge.domain;

import java.util.List;

public class Round {
    private List<String> movings;

    public Round(List<String> movings) {
        this.movings = movings;
    }

    public void addMoving(String moving) {
        this.movings.add(moving);
    }

    public String findLastValue() {
        return this.movings.get(movings.size() - 1);
    }

    public int findLastIndex() {
        return this.movings.size() - 1;
    }

    public List<String> getMovings() {
        return movings;
    }
}
