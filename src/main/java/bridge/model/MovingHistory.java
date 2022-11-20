package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MovingHistory {

    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    public static final String BLANK = " ";

    private List<MovingResult> history;

    public MovingHistory() {
        history = new ArrayList<>();
    }

    public void save(MovingResult movingResult) {
        history.add(movingResult);
    }

    public List<String> getUpSide() {
        ArrayList<String> upSideHistory = new ArrayList<>();
        for (MovingResult movingResult : history) {
            upSideHistory.add(getUpSideResult(movingResult));
        }
        return upSideHistory;
    }

    public List<String> getDownSide() {
        ArrayList<String> downSideHistory = new ArrayList<>();
        for (MovingResult movingResult : history) {
            downSideHistory.add(getDownSideResult(movingResult));
        }
        return downSideHistory;
    }

    private String getUpSideResult(MovingResult movingResult) {
        if (movingResult.isUpSide()) {
            if (movingResult.isSuccess()) {
                return SUCCESS;
            }
            return FAIL;
        }
        return BLANK;
    }

    private String getDownSideResult(MovingResult movingResult) {
        if (movingResult.isDownSide()) {
            if (movingResult.isSuccess()) {
                return SUCCESS;
            }
            return FAIL;
        }
        return BLANK;
    }

    public void reset() {
        history = new ArrayList<>();
    }
}
