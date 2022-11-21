package bridge.domain.pedestrian;

import bridge.domain.direction.Direction;
import bridge.domain.movingrecord.MovingRecord;
import bridge.domain.referee.Judgement;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pedestrian {

    private final Map<Judgement, Direction> movingRecords;

    public Pedestrian() {
        this.movingRecords = new LinkedHashMap<>();
    }

    public void move(Judgement judgement, Direction direction) {
        movingRecords.put(judgement, direction);
    }

    public int findLocation() {
        return movingRecords.size();
    }

    public void returnToStartPoint() {
        movingRecords.clear();
    }

    public boolean hasIncorrectDirection() {
        return movingRecords.keySet().stream()
                .anyMatch(Judgement::isFalse);
    }

    public MovingRecord createMovingRecord() {
        return new MovingRecord(movingRecords);
    }

    @Override
    public String toString() {
        return "Pedestrian{" +
                "movingRecords=" + movingRecords +
                '}';
    }
}
