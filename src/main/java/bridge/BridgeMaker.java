package bridge;

import static bridge.constant.gameValue.DOWN;
import static bridge.constant.gameValue.UP;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int UP_NUMBER = 1;
    private static final int DOWN_NUMBER = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeComponents = new ArrayList<>();
        for (int number = 0; number < size; number++) {
            addBridgeNumbers(bridgeComponents);
        }
        return bridgeComponents;
    }

    private void addBridgeNumbers(List<String> bridgeComponents) {
        int randomNumber = bridgeNumberGenerator.generate();
        addBridgeComponents(bridgeComponents, randomNumber);
    }

    private void addBridgeComponents(List<String> bridgeComponents, int randomNumber) {
        if (randomNumber == UP_NUMBER) {
            bridgeComponents.add(UP);
        }
        if (randomNumber == DOWN_NUMBER) {
            bridgeComponents.add(DOWN);
        }
    }
}
