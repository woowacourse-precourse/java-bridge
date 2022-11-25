package bridge.domain.factory;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class BridgeFactory {

    public Bridge createBridge(int size) {
        BridgeMaker maker = createBridgeMaker();
        List<String> bridge = maker.makeBridge(size);
        return new Bridge(makeDirections(bridge));
    }

    private List<Direction> makeDirections(List<String> bridge) {
        return bridge.stream()
                .map(Direction::new)
                .collect(Collectors.toList());
    }

    private BridgeMaker createBridgeMaker() {
        return new BridgeMaker(createBridgeNumberGenerator());
    }

    private BridgeNumberGenerator createBridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
