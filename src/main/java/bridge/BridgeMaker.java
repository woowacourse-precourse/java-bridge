package bridge;

import static bridge.util.BridgeConstant.DOWN_KEY_NUMBER;
import static bridge.util.BridgeConstant.DOWN_KEY;
import static bridge.util.BridgeConstant.UP_KEY_NUMBER;
import static bridge.util.BridgeConstant.UP_KEY;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

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
        for (int i = 0; i < size; i++) {
            int key = bridgeNumberGenerator.generate();
            bridge.add(addBridge(key));
        }
        return bridge;
    }

    private String addBridge(int key) {
        if (key == DOWN_KEY_NUMBER) {
            return DOWN_KEY;
        } else if (key == UP_KEY_NUMBER) {
            return UP_KEY;
        }
        throw new IllegalArgumentException("0 혹은 1의 값을 입력받아야 합니다.");
    }

    public String[][] make2DBridge(List<String> bridge) {
        String[][] bridge2D = new String[2][bridge.size()];
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i) == DOWN_KEY) {
                bridge2D[1][i] = DOWN_KEY;
                bridge2D[0][i] = "X";
            } else {
                bridge2D[0][i] = UP_KEY;
                bridge2D[1][i] = "X";
            }
        }
        return bridge2D;
    }
}
