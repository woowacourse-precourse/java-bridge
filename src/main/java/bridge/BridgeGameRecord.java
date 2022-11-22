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

}
