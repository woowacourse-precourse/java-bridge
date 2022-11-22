package bridge;

import static bridge.viewer.ErrorMessage.BRIDGE_LENGTH_ERROR;
import static bridge.viewer.MoveCommand.DOWN;
import static bridge.viewer.MoveCommand.UP;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int NUMBER_UP = 1;
    private final int MINIMUM_LENGTH = 3;
    private final int MAXIMUM_LENGTH = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) throws IllegalArgumentException {
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i=0; i<size; i++) {
            bridge.add(mapToString(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validateSize(int size) throws IllegalStateException {
        if (size > MAXIMUM_LENGTH || size < MINIMUM_LENGTH) {
            throw new IllegalStateException(BRIDGE_LENGTH_ERROR);
        }
    }

    private String mapToString(int number) {
        if (number == NUMBER_UP) {
            return UP;
        }
        return DOWN;
    }
}
