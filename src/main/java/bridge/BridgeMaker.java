package bridge;

import bridge.model.UserKeySet;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String cell = generateCell();
            bridge.add(cell);
        }
        return bridge;
    }

    private String generateCell() {
        int movableCell = bridgeNumberGenerator.generate();

        if(movableCell > 0) {
            return UserKeySet.UP.toString();
        }

        return UserKeySet.DOWN.toString();
    }
}
