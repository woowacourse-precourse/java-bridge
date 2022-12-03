package bridge;

import bridge.model.Direction;
import bridge.model.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> preBridge = Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .collect(Collectors.toUnmodifiableList());
        return preBridge.stream()
                .map(Direction::getInputByValue)
                .collect(Collectors.toUnmodifiableList());
    }

}
