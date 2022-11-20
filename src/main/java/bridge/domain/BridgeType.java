package bridge.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeType {
    UPPER_BRIDGE(1, "U"),
    DOWN_BRIDGE(0, "D");

    private final int numNotation;
    private final String engNotation;

    BridgeType(int numNotation, String engNotation){
        this.numNotation = numNotation;
        this.engNotation = engNotation;
    }

    private static final Map<Integer, BridgeType> bridgeTypeByNumNotation =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeType::getNumNotation, Function.identity())));

    public int getNumNotation(){
        return this.numNotation;
    }

    public String getEngNotation(){
        return engNotation;
    }

    public static BridgeType getBridgeTypeByNumNotation(int numNotation){
        return Optional
                .ofNullable(bridgeTypeByNumNotation.get(numNotation))
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없음"));
    }
}
