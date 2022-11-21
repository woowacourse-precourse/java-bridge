package bridge.domain;

import bridge.BridgeNumberGenerator;

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
        List<String> rightBridgeWay = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            rightBridgeWay.add(changeNumber(randomNumber));
        }
        return rightBridgeWay;
    }

    public String changeNumber(int randomNumber) {
        String rightWay = null;

        if (randomNumber == Direction.UP.getNumber()) {
            rightWay = Direction.UP.getWord();
        }
        if (randomNumber == Direction.DOWN.getNumber()) {
            rightWay = Direction.DOWN.getWord();
        }
        return rightWay;
    }
}
