package bridge;

import bridge.type.PositionType;

import java.util.LinkedList;
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
        List<String> bridge = new LinkedList<>();
        for (int tries = 0; tries < size; tries++) {
            bridge.add(this.getBridgeTypeName());
        }
        return bridge;
    }

    private String getBridgeTypeName() {
        String typeName = PositionType
                .build(this.bridgeNumberGenerator.generate())
                .getTypeName();

        this.checkBridgeTypeIsUnknown(typeName);

        return typeName;
    }

    private void checkBridgeTypeIsUnknown(String bridgeTypeName) {
        if (bridgeTypeName.equals(PositionType.UNKNOWN.getTypeName())) {
            throw new RuntimeException(Lang.get(Lang.SLAB_TYPE_IS_UNKNOWN));
        }
    }

    public static BridgeMaker getInstance() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

        return new BridgeMaker(generator);
    }
}
