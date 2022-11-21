package bridge.domain;

import bridge.domain.enums.CrossStatus;
import java.util.List;

public class CrossStatuses {
    private final List<CrossStatus> crossStatuses;

    public CrossStatuses(final List<CrossStatus> crossStatuses) {
        this.crossStatuses = crossStatuses;
    }

    public int findUncrossedIndex() {
        return crossStatuses.indexOf(CrossStatus.YET);
    }

    public void updateStatus(final CrossStatus crossedStatus, final int uncrossedIndex) {
        crossStatuses.set(uncrossedIndex, crossedStatus);
        System.out.println(crossStatuses);
    }
}
