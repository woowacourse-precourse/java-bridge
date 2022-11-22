package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeRecord {
    private static final List<Command> bridgeRecord = new ArrayList<>();

    public static List<Command> getBridgeRecord() {
        return Collections.unmodifiableList(bridgeRecord);
    }

    public static void update(Command command) {
        bridgeRecord.add(command);
    }
}
