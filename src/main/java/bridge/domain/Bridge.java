package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    private final List<String> bridge;

    public Bridge(int size){
        validateSize(size);
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    private void validateSize(int size){
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_BRIDGE_SIZE.getMessage());
        }
    }

    public static int getBridgeMaxSize() {
        return BRIDGE_MAX_SIZE;
    }

    public static int getBridgeMinSize() {
        return BRIDGE_MIN_SIZE;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
