package bridge.domain.bridge;

import bridge.domain.BridgeLocation;
import bridge.value.BridgeCharacter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeCharacter> bridge;

    public Bridge(List<BridgeCharacter> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public static Bridge convert(List<String> bridgeChars) {
        return new Bridge(bridgeChars.stream().map(BridgeCharacter::makeBridgeCharacter).collect(Collectors.toList()));
    }

    private void validate(List<BridgeCharacter> bridge) {
        if (!(3 <= bridge.size() && bridge.size() <= 20)) {
            throw new IllegalArgumentException("다리의 길이가 범위에 해당되지 않습니다.");
        }
    }

    public boolean isRange(BridgeLocation bridgeLocation) {
        return bridgeLocation.isBelow(bridge.size());
    }

    public boolean canMove(BridgeLocation bridgeLocation, BridgeCharacter bridgeCharacter) {
        if (!isRange(bridgeLocation.next())) {
            throw new IllegalStateException("더이상 이동할 수 없습니다.");
        }
        return bridge.get(bridgeLocation.value()).equals(bridgeCharacter);
    }

    public List<BridgeCharacter> characters() {
        return new ArrayList<>(bridge);
    }
}
