package bridge.domain;

import static bridge.domain.enums.CrossStatus.FAIL;
import static bridge.domain.enums.CrossStatus.SUCCESS;
import static bridge.domain.enums.CrossStatus.YET;

import bridge.domain.enums.CrossStatus;
import java.util.List;

public class CrossStatuses {
    private final List<CrossStatus> crossStatuses;

    public CrossStatuses(final List<CrossStatus> crossStatuses) {
        this.crossStatuses = crossStatuses;
    }

    public int findUncrossedIndex() {
        return crossStatuses.indexOf(YET);
    }

    public CrossStatus updateStatus(final CrossStatus crossedStatus, final int uncrossedIndex) {
        crossStatuses.set(uncrossedIndex, crossedStatus);
        return crossedStatus;
    }

    public boolean isFail() {
        return crossStatuses.contains(FAIL);
    }

    public int findFailIndex() {
        return crossStatuses.indexOf(FAIL);
    }

    public int findLastSuccessIndex() {
        return crossStatuses.lastIndexOf(SUCCESS);
    }
}
