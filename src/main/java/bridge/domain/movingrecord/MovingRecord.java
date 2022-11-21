package bridge.domain.movingrecord;

import bridge.domain.direction.Direction;
import bridge.domain.referee.Judgement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovingRecord {

    public static final int CORRECT_DIRECTION = 1;
    public static final int INCORRECT_DIRECTION = 0;
    public static final int NOTHING = -1;
    private final Map<Judgement, Direction> records;

    public MovingRecord(Map<Judgement, Direction> records) {
        this.records = records;
    }

    public List<Integer> makeBridgeSketches(Direction bridgeDirection) {
        return records.entrySet().stream()
                .map(record -> makeSketch(record, bridgeDirection))
                .collect(Collectors.toUnmodifiableList());
    }

    private int makeSketch(Map.Entry<Judgement, Direction> record, Direction bridgeDirection) {
        Direction direction = record.getValue();
        Judgement judgement = record.getKey();
        if (direction.equals(bridgeDirection) && judgement.isTrue()) {
            return CORRECT_DIRECTION;
        }
        if (direction.equals(bridgeDirection) && judgement.isFalse()) {
            return INCORRECT_DIRECTION;
        }
        return NOTHING;
    }

    @Override
    public String toString() {
        return "MovingRecord{" +
                "records=" + records +
                '}';
    }
}
