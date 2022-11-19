package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<Floor> floors;

    public Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        this.floors = bridge.stream()
                .map(each -> new Floor(each))
                .collect(Collectors.toList());
    }

    public boolean isSafe(int index, String input) {
        Floor floor = floors.get(index);
        return floor.isSafe(input);
    }

    public int size() {
        return floors.size();
    }
}
