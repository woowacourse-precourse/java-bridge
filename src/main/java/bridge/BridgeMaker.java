package bridge;

import static bridge.constant.BridgeConstants.DOWN_SIDE;
import static bridge.constant.BridgeConstants.DOWN_SIDE_INDEX;
import static bridge.constant.BridgeConstants.UP_SIDE;

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
        String bridgeBuilder = "";

        for(int step=0; step<size;step++){
            bridgeBuilder += convertToBridgeSource(generateBridgeNumber());
        }

        return List.of(bridgeBuilder.split(""));
    }

    private int generateBridgeNumber() {
        return bridgeNumberGenerator.generate();
    }

    private String convertToBridgeSource(int number) {
        if (number == DOWN_SIDE_INDEX) {
            return DOWN_SIDE;
        }
        return UP_SIDE;
    }
}
