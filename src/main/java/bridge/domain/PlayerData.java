package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {
    private List<String> movementHistory = new ArrayList<>();
    private int countOfTry = 1;

    public void recordMovement(String movement) {
        movementHistory.add(movement);
    }

    public List<String> getMovementHistory() {
        return movementHistory;
    }

    public void resetMovementHistroy() {
        movementHistory.clear();
    }

    public int getCountOfTry() {
        return countOfTry;
    }

    public void increaseCountOfTry() {
        countOfTry++;
    }

    public int getIndexOfMovement() {
        return movementHistory.size() - 1;
    }
}
