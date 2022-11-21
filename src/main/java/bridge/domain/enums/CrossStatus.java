package bridge.domain.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CrossStatus {
    SUCCESS, FAIL, YET;

    public static List<CrossStatus> createInitializationStatuses(final int bridgeSize) {
        return Stream.generate(() -> YET)
                .limit(bridgeSize)
                .collect(Collectors.toList());
    }
}
