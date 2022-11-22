package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator; // 변경이 불가능한 기본 인스턴스 변수

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(generateBridgeSide());
        }
        return bridge;
    }

    private String generateBridgeSide() {
        int bridgeNumber = bridgeNumberGenerator.generate();
        if (bridgeNumber == 1) {
            return "U";
        }
        return "D";
    }
}
