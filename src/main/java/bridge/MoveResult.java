package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private List<String> history;
    private MoveStatus moveStatus;

    public MoveResult(List<String> history, MoveStatus moveStatus) {
        this.history = history;
        this.moveStatus = moveStatus;
    }

    public List<String> getHistory() {
        return new ArrayList<>(this.history);
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }
}
