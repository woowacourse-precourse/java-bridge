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

}
