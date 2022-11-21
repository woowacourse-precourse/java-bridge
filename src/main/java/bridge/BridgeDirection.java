package bridge;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeDirection {
    U(1),
    D(0);

    private static final Map<Integer, String> DIRECTION_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(BridgeDirection::getDirectionNumber, BridgeDirection::name)));

    private final int directionNumber;
    private BridgeDirection(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    public Integer getDirectionNumber(){
        return directionNumber;
    }

    public static BridgeDirection of(int directionNumber) {
        return BridgeDirection.valueOf(DIRECTION_MAP.get(directionNumber));
    }
}
