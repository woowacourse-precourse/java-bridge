package bridge;

import bridge.identifiers.Direction;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    public static final int BRIDGE_MAX_LENGTH = 20;
    public static final int BRIDGE_MIN_LENGTH = 3;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validate(size);
        List<String> securePath = new ArrayList<>(size);
        while (size-- != 0) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            Direction direction = Direction.parseDirection(bridgeNumber);
            securePath.add(direction.getAsString());
        }
        return securePath;
    }

    private void validate(int size) {
        if (size < BRIDGE_MIN_LENGTH || BRIDGE_MAX_LENGTH < size) {
            throw new IllegalArgumentException(
                    "다리의 길이는 3이상 20이하의 값이어야 합니다."
            );
        }
    }
}
