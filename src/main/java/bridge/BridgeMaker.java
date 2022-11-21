package bridge;

import bridge.constant.BridgeDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        for (int count = 0; count < size; count++) {
            int bridgeNumber = bridgeNumberGenerator.generate();

            Arrays.stream(BridgeDirection.values())
                    .filter(bridgeDirection -> bridgeNumber  == bridgeDirection.getRandomNumber())
                    .forEach(bridgeDirection -> bridge.add(bridgeDirection.getMark()));
        }
        return bridge;
    }
}
