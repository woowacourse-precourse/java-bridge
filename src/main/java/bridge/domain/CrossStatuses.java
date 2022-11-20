package bridge.domain;

import bridge.domain.enums.CrossStatus;
import java.util.List;

public class CrossStatuses {
    private final List<CrossStatus> crossStatuses;

    public CrossStatuses(final List<CrossStatus> crossStatuses) {
        this.crossStatuses = crossStatuses;
    }
}
