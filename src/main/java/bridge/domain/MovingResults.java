package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MovingResults {
    private final List<MovingResult> movingResults;

    public MovingResults() {
        this.movingResults = new ArrayList<>();
    }

    public void clear() {
        movingResults.clear();
    }

    public void add(MovingResult movingResult) {
        movingResults.add(movingResult);
    }

    public List<MovingResult> get() {
        return movingResults;
    }
}
