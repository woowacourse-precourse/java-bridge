package bridge.service;

import bridge.type.MapComponentType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMakerImpl implements BridgeMaker{

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMakerImpl(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    @Override
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .map(count -> bridgeNumberGenerator.generate())
                .mapToObj(MapComponentType::getMapComponent)
                .collect(Collectors.toUnmodifiableList());
    }
}
