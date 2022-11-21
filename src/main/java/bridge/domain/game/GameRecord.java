package bridge.domain.game;

import static bridge.value.RecordValue.RECORD_INCREMENT;
import static bridge.value.RecordValue.RECORD_INIT;

public class GameRecord {
    private int retryCount;

    public GameRecord() {
        this.retryCount = RECORD_INIT.getValue();
    }

    public void addRetryCount() {
        this.retryCount += RECORD_INCREMENT.getValue();
    }

    public int getRetryCount() {
        return retryCount;
    }
}
