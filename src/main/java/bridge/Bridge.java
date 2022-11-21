package bridge;

import bridge.type.PositionType;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final int size;
    private final List<PositionType> passBridges;

    // TODO : Exception message 처리
    public Bridge(int size, BridgeMaker bridgeMaker) {
        this.size = size;
        this.passBridges = bridgeMaker.makeBridge(size)
                .stream()
                .map(symbol -> PositionType.matchSymbol(symbol).orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList());
    }

    public int getSize() {
        return size;
    }

    public PositionType currentPosition(int start) {
        return passBridges.get(start);
    }

    public List<PositionType> getPassBridges() {
        return passBridges;
    }
}