package bridge;

import java.util.List;

public class Judgement {
    public boolean checkArrival(Record movingRecord, List<String> bridge){
        if (bridge.size() != movingRecord.getRecordLength()) return false;
        for (int i = 0 ; i < movingRecord.getRecordLength() ;i++) {
            if (!bridge.get(i).equals( movingRecord.getRecord().get(i)))
                return false;
        }
        return true;
    }
    public boolean checkDirection(Record movingRecord, String direction, List<String> bridge){
        if (bridge.get(movingRecord.getRecordLength()).equals(direction))
            return true;
        return false;
    }
}
