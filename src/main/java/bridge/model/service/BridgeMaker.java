package bridge.model.service;

import bridge.BridgeNumberGenerator;

import java.util.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator BRIDGE_NUMBER_GENERATOR;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.BRIDGE_NUMBER_GENERATOR = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = BRIDGE_NUMBER_GENERATOR.generate();
            bridge.add(returnBridgeValue(randomNumber));
        }

        System.out.println(bridge);

        return bridge;
    }

    private String returnBridgeValue(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }

        if (randomNumber == 1) {
            return "U";
        }

        return null;
    }
}
