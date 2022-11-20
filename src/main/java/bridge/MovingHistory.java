package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovingHistory {

    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    public static final String BLANK = " ";

    private List<MovingResult> history;

    public MovingHistory() {
        history = new ArrayList<>();
    }

    public void addMovingResult(MovingResult movingResult) {
        history.add(movingResult);
    }

    public List<String> getUpSide() {
        return history.stream()
                .filter(MovingResult::isUpSide)
                .map(movingResult -> getSideResult(movingResult))
                .collect(Collectors.toList());
    }

    public List<String> getDownSide() {
        return history.stream()
                .filter(MovingResult::isDownSide)
                .map(movingResult -> getSideResult(movingResult))
                .collect(Collectors.toList());
    }

    private String getSideResult(MovingResult movingResult) {
        if (movingResult.isSuccess()) {
            return SUCCESS;
        }
        if (movingResult.isFail()) {
            return FAIL;
        }
        return BLANK;
    }
}
