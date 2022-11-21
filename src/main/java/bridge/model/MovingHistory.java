package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MovingHistory {

    private List<MovingResult> history;

    public MovingHistory() {
        history = new ArrayList<>();
    }

    public void save(MovingResult movingResult) {
        history.add(movingResult);
    }

    public void reset() {
        history = new ArrayList<>();
    }

    public SideMap getUpSideMap() {
        return new UpSideMap(history);
    }

    public SideMap getDownSideMap() {
        return new DownSideMap(history);
    }
}
