package bridge.domain.movingrecord;

import bridge.domain.direction.Direction;
import bridge.domain.referee.Judgement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MovingRecord {

    private final Map<Judgement, Direction> record;

    public MovingRecord() {
        this.record = new LinkedHashMap<>();
    }

    public void write(Judgement judgement, Direction direction) {
        record.put(judgement, direction);
    }

    public Stream<Map.Entry<Judgement, Direction>> read() {
        return record.entrySet().stream();
    }

    public int size() {
        return record.size();
    }

    public void clear() {
        record.clear();
    }

    @Override
    public String toString() {
        return "MovingRecord{" +
                "record=" + record +
                '}';
    }
}
