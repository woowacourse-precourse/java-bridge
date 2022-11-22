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

    public static String valueOfStatus(boolean status) {
        if (status) {
            return "O";
        }
        return "X";
    }

    public void addMoving(String moving, boolean movingStatus) {
        if (moving.equals(CellType.DOWN.getCell())){
            downCells.add(valueOfStatus(movingStatus));
            upCells.add(" ");
        }
        if (moving.equals(CellType.UP.getCell())){
            upCells.add(valueOfStatus(movingStatus));
            downCells.add(" ");
        }
    }

    public void clearHistory() {
        upCells.clear();
        downCells.clear();
    }

    public List<String> getUpCells() {
        return upCells;
    }

    public List<String> getDownCells() {
        return downCells;
    }
}
