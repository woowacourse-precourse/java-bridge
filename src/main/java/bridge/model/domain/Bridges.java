package bridge.model.domain;

import bridge.constant.Constant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {

    private final List<Bridge> bridges;

    public Bridges(List<String> bridgesSign) {
        this.bridges = bridgesSign.stream()
                .map(Bridge::findBySign)
                .collect(Collectors.toList());
    }

    Bridge findBridgeByPosition(int position) {
        return bridges.get(position);
    }

    List<Integer> readBridgeMap(int bridgeLastPosition) {
        return IntStream.rangeClosed(Constant.INITIAL_INDEX, bridgeLastPosition)
                .mapToObj(this::findBridgeTypeByPosition)
                .collect(Collectors.toList());
    }

    private int findBridgeTypeByPosition(int position) {
        return bridges.get(position)
                .getBridgeType();
    }

    int size() {
        return bridges.size();
    }
}
