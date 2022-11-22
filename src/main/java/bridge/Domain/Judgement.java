package bridge.Domain;

import java.util.List;

public class Judgement {

    public boolean checkArrival(Record movingRecord, List<String> bridge) {
        if (bridge.size() != movingRecord.getRecordLength())
            return false;
        return true;
    }

    public boolean checkSameDirection(Record movingRecord, String direction, List<String> bridge) {
        if (bridge.get(movingRecord.getRecordLength()-1).equals(direction))
            return true;
        return false;
    }
}
