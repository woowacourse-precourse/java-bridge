package bridge;

import bridge.type.SlabType;
import bridge.type.LangType;

import java.util.LinkedList;
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
        List<String> bridge = new LinkedList<>();
        for (int tries = 0; tries < size; tries++) {
            bridge.add(this.getBridgeTypeName());
        }
        return bridge;
    }

    private String getBridgeTypeName() {
        String typeName = SlabType
                .build(this.bridgeNumberGenerator.generate())
                .getTypeName();

        this.checkBridgeTypeIsUnknown(typeName);

        return typeName;
    }

    private void checkBridgeTypeIsUnknown(String bridgeTypeName) {
        if (bridgeTypeName.equals(SlabType.UNKNOWN.getTypeName())) {
            throw new RuntimeException(LangType.get(LangType.SLAB_TYPE_IS_UNKNOWN));
        }
    }
}
