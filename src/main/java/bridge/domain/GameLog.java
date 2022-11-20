package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameLog {
    private final List<String> upperCrossedRecord;
    private final List<String> lowerCrossedRecord;
    private int tryCount;
    public GameLog() {
        upperCrossedRecord = new ArrayList<>();
        lowerCrossedRecord = new ArrayList<>();
        this.tryCount = 0;
    }
}
