package bridge.domain.bridge;

import bridge.value.BridgeCharacter;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeCharacter> bridge;

    public Bridge(List<BridgeCharacter> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public static Bridge convert(List<String> bridgeChars) {
        return new Bridge(bridgeChars.stream().map(BridgeCharacter::MakeBridgeCharacter).collect(Collectors.toList()));
    }

    private void validate(List<BridgeCharacter> bridge) {
        if(!(3<= bridge.size() && bridge.size() <= 20 )) {
            throw new IllegalArgumentException("다리의 길이가 범위에 해당되지 않습니다.");
        }
    }

    public boolean isRange(int index) {
        return bridge.size() <= index;
    }

    public boolean canMove(int index, BridgeCharacter bridgeCharacter) {
        if(isRange(index)) {
            return false;
        }
        return bridge.get(index).equals(bridgeCharacter);
    }
}
