package bridge;

import bridge.domain.game.BridgeTile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumbers = makeBridgeNumbers(size);

        return bridgeNumbers
                .stream()
                .map(BridgeTile::mapToCommand)
                .collect(Collectors.toList());
    }

    private List<Integer> makeBridgeNumbers(int size) {
        List<Integer> bridge = new ArrayList<>();

        while (bridge.size() < size) {
            bridge.add(bridgeNumberGenerator.generate());
        }

        return bridge;
    }
}
