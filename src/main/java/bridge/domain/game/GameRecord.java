package bridge.domain.game;

import static bridge.value.RecordValue.INCREMENT;
import static bridge.value.RecordValue.INIT;

public class GameRecord {
    private int retryCount;

    public GameRecord() {
        this.retryCount = INIT.getValue();
    }

    public void addRetryCount() {
        this.retryCount += INCREMENT.getValue();
    }

    public int getRetryCount() {
        return retryCount;
    }
}
