package bridge.domain;

import bridge.type.PositionType;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<PositionType> passBridges;

    // TODO : Exception message 처리
    public Bridge(List<String> passBridges) {
        this.passBridges = passBridges.stream()
                .map(symbol -> PositionType.matchSymbol(symbol).orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList());
    }


    public PositionType currentPosition(int start) {
        return passBridges.get(start);
    }

    public List<PositionType> getPassBridges() {
        return this.passBridges;
    }

    public int size() {
        return this.passBridges.size();
    }
}