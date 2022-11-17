package bridge;

import constant.GameConstant;
import constant.StringConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            if (isBridgeNumberDownSide(bridgeNumber)) {
                addBridgeDownPath(bridge);
            }
            if (isBridgeNumberUpSide(bridgeNumber)) {
                addBridgeUpPath(bridge);
            }
        }
        return Collections.unmodifiableList(bridge);
    }

    public boolean isBridgeNumberDownSide(int bridgeNumber){
        return bridgeNumber == GameConstant.DOWN_SIDE.getConstant();
    }

    public boolean isBridgeNumberUpSide(int bridgeNumber){
        return bridgeNumber == GameConstant.UP_SIDE.getConstant();
    }

    public List<String> addBridgeDownPath(List<String> bridge){
        bridge.add(StringConstant.DOWN_SIDE.getConstant());
        return bridge;
    }

    public List<String> addBridgeUpPath(List<String> bridge){
        bridge.add(StringConstant.UP_SIDE.getConstant());
        return bridge;
    }


}