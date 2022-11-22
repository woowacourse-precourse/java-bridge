package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameRecord {

    private List<String> record = new ArrayList<>();

    public List<String> getRecord() {
        return record;
    }

    public void addNextPosition(String side) {
        record.add(side);
    }

    public boolean endMatchWith(List<String> answerBridge) {
        return record.get(record.size() - 1)
                .equals(answerBridge.get(record.size() - 1));
    }

    public String getLaneString(String side, List<String> answerBridge) {
        String laneString= "[";

        for (int i = 0 ; i < record.size() ; i++) {
            if (record.get(i).equals(side) && record.get(i).equals(answerBridge.get(i))) laneString += " O ";
            else if (record.get(i).equals(side) && !record.get(i).equals(answerBridge.get(i))) laneString += " X ";
            else if (!record.get(i).equals(side)) laneString += "   ";
            if (i < record.size()-1) laneString += "|";
        }
        laneString += "]";
        return laneString;
    }
}
