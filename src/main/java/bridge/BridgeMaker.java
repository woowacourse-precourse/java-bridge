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

    public List<SlabType> makeBridge(int size) {
        List<SlabType> bridge = new LinkedList<>();

        for (int tries = 0; tries < size; tries++) {
            bridge.add(this.getSlabType());
        }

        return bridge;
    }

    private SlabType getSlabType() {
        SlabType bridgeTypeName = SlabType.create(this.bridgeNumberGenerator.generate());
        this.checkSlabValid(bridgeTypeName);

        return bridgeTypeName;
    }

    private void checkSlabValid(SlabType slab) {
        if (slab.equals(SlabType.UNKNOWN)) {
            throw new RuntimeException(LangType.get(LangType.THROW_UNKNOWN_BRIDGE_TYPE));
        }
    }
}
