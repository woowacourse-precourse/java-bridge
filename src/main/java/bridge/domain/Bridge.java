package bridge.domain;

import bridge.type.PositionType;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<PositionType> passBridges; // PositionType 으로 표현

    // 건널 수 있는 다리를 List<String> 으로 받고 PositionType 으로 매핑
    public Bridge(List<String> passBridges) {
        this.passBridges = passBridges.stream()
                .map(symbol -> PositionType.matchSymbol(symbol).orElseThrow(() -> new IllegalArgumentException("[ERROR] Position is not match !!")))
                .collect(Collectors.toList());
    }

    // 현재 건널 수 있는 다리를 가져온다.
    public PositionType currentPosition(int start) {
        return passBridges.get(start);
    }

    // 다리의 길이
    public int size() {
        return this.passBridges.size();
    }
}