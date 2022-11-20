package bridge.domain.enums;

import bridge.domain.CrossStatuses;
import java.util.ArrayList;
import java.util.List;

public enum CrossStatus {
    SUCCESS, FAIL, YET;

    public static CrossStatuses createInitializationStatuses(final int bridgeSize) {
        List<CrossStatus> crossStatuses = new ArrayList<>();
        for (int bridgeIndex = 0; bridgeIndex < bridgeSize; bridgeIndex++) {
            crossStatuses.add(YET);
        }
        return new CrossStatuses(crossStatuses);
    }
}
