package bridge;

import bridge.type.SlabType;
import bridge.type.LangType;

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
        String bridgeTypeName = SlabType
                .build(this.bridgeNumberGenerator.generate())
                .getTypeName();

        this.checkBridgeTypeName(bridgeTypeName);

        return bridgeTypeName;
    }
    private void checkBridgeTypeName(String bridgeTypeName) {
        if (bridgeTypeName.equals(SlabType.UNKNOWN.getTypeName())) {
            throw new RuntimeException(LangType.get(LangType.SLAB_TYPE_IS_UNKNOWN));
        }
    }
}
