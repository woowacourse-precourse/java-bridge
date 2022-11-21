package bridge.domain.pedestrian;

import bridge.domain.direction.Direction;
import bridge.domain.movingrecord.MovingRecord;
import bridge.domain.referee.Judgement;

import java.util.Map;
import java.util.stream.Stream;

public class Pedestrian {

    private final MovingRecord movingRecord;

    public Pedestrian() {
        this.movingRecord = new MovingRecord();
    }

    public void move(Judgement judgement, Direction direction) {
        movingRecord.write(judgement, direction);
    }

    public Stream<Map.Entry<Judgement, Direction>> readRecord() {
        return movingRecord.read();
    }

    public int findLocation() {
        return movingRecord.size();
    }

    public void clearRecord() {
        movingRecord.clear();
    }

    public boolean hasIncorrectDirection() {
        return movingRecord.hasFalseJudgement();
    }
}
