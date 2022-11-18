package bridge;

import bridge.type.BridgeType;

import java.util.LinkedList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new LinkedList<>();

        for (int tries = 0; tries < size; tries++) {
            bridge.add(this.getBridgeTypeName());
        }

        return bridge;
    }

    private String getBridgeTypeName() {
        String bridgeTypeName = BridgeType
                .create(this.bridgeNumberGenerator.generate())
                .getTypeName();
        this.checkBridgeTypeName(bridgeTypeName);

        return bridgeTypeName;
    }

    private void checkBridgeTypeName(String bridgeTypeName) {
        if (bridgeTypeName.equals(BridgeType.UNKNOWN.getTypeName())) {
            throw new RuntimeException("알 수 없는 브리지 타입이 입력되었습니다.");
        }
    }
}
