package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int UP_BRIDGE_NUMBER = 1;
    private static final int DOWN_BRIDGE_NUMBER = 0;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public static int getBridgeMinSize() {
        return BRIDGE_MIN_SIZE;
    }

    public static int getBridgeMaxSize() {
        return BRIDGE_MAX_SIZE;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        List<Integer> bridgeNumbers = new ArrayList<>();
        List<String> bridgeCharacters = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridgeNumbers.add(bridgeNumber);
        }

        for (Integer bridgeNumber : bridgeNumbers) {
            if (bridgeNumber == UP_BRIDGE_NUMBER) {
                bridgeCharacters.add(BridgeGame.getUpBridgeCharacter());
            }
            if (bridgeNumber == DOWN_BRIDGE_NUMBER) {
                bridgeCharacters.add(BridgeGame.getDownBridgeCharacter());
            }
        }
        return bridgeCharacters;
    }

    private void validateSize(int size) {
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_SIZE_ERROR.getMessage());
        }
    }
}
