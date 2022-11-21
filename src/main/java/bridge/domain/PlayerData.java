package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {
    private static final int INITIAL_VALUE = 1;
    private List<String> movementRecord = new ArrayList<>();
    private int countOfTry = INITIAL_VALUE;

    public void add(String movement) {
        movementRecord.add(movement);
    }

    public List<String> getMovementRecord() {
        return movementRecord;
    }

    public void clearMovementRecord() {
        movementRecord.clear();
    }

    public int getCountOfTry() {
        return countOfTry;
    }

    public void increaseCountOfTry() {
        countOfTry++;
    }

    public int getIndexOfMovementRecord() {
        return movementRecord.size() - 1;
    }
}
