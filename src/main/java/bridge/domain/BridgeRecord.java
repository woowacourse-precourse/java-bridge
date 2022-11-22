package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeRecord {
    private final List<Command> bridgeRecord = new ArrayList<>();

    public List<Command> getBridgeRecord() {
        return Collections.unmodifiableList(bridgeRecord);
    }

    public void update(Command command) {
        bridgeRecord.add(command);
    }
}
