package bridge.domain.bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeMapComponent> bridgeMapComponents;

    private Bridge(List<BridgeMapComponent> bridgeMapComponents) {
        this.bridgeMapComponents = bridgeMapComponents;
    }

    public static Bridge from(List<String> bridgeBlueprint) {
        List<BridgeMapComponent> mapComponents = bridgeBlueprint.stream()
                .map(BridgeMapComponent::fromSignature)
                .collect(Collectors.toUnmodifiableList());

        return new Bridge(mapComponents);
    }

    public int size() {
        return this.bridgeMapComponents.size();
    }

    public List<BridgeMapComponent> getBridgeMapComponents() {
        return bridgeMapComponents;
    }
}
