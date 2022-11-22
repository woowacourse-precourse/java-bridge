package bridge;

import bridge.constants.ErrorMessages;
import bridge.domain.enums.Direction;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int SIZE_MINIMUM = 3;
    private static final int SIZE_MAXIMUM = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);

        List<String> bridge = new ArrayList<>();
        while (bridge.size() < size) {
            bridge.add(createMaterial());
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (size < SIZE_MINIMUM || size > SIZE_MAXIMUM) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE_SIZE);
        }
    }

    private String createMaterial() {
        int randomNumber = bridgeNumberGenerator.generate();

        if (randomNumber == Direction.DOWN.getNumber()) {
            return Direction.DOWN.getCommand();
        }
        return Direction.UP.getCommand();
    }

}
