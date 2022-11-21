package bridge.domain.bridge;

import bridge.domain.BridgeLocation;
import bridge.validate.BridgeValidation;
import bridge.value.BridgeCharacter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeCharacter> bridge;

    public Bridge(List<BridgeCharacter> bridge) {
        BridgeValidation.validateBridgeSize(bridge);
        this.bridge = bridge;
    }

    public static Bridge convert(List<String> bridgeChars) {
        return new Bridge(bridgeChars.stream().map(BridgeCharacter::makeBridgeCharacter).collect(Collectors.toList()));
    }

    public boolean isRange(BridgeLocation bridgeLocation) {
        return bridgeLocation.isBelow(bridge.size());
    }

    public boolean canMove(BridgeLocation bridgeLocation, BridgeCharacter bridgeCharacter) {
        BridgeValidation.validateBridgeMovable(isRange(bridgeLocation));

        return bridge.get(bridgeLocation.value()).equals(bridgeCharacter);
    }

    public List<BridgeCharacter> characters() {
        return new ArrayList<>(bridge);
    }
}
