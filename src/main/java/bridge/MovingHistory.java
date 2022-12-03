package bridge;

import java.util.ArrayList;
import java.util.List;

public class MovingHistory {

    private final List<String> upCells;
    private final List<String> downCells;

    public MovingHistory() {
        this.upCells = new ArrayList<>();
        this.downCells = new ArrayList<>();
    }

    public List<String> getUpCells() {
        return upCells;
    }

    public List<String> getDownCells() {
        return downCells;
    }

    public void clearHistory() {
        upCells.clear();
        downCells.clear();
    }

    public void addMoving(String moving, boolean movingStatus) {
        if (moving.equals(CommandType.DOWN.getValue())){
            downCells.add(GameResult.getMovingSign(movingStatus));
            upCells.add(" ");
        }
        if (moving.equals(CommandType.UP.getValue())){
            upCells.add(GameResult.getMovingSign(movingStatus));
            downCells.add(" ");
        }
    }
}
