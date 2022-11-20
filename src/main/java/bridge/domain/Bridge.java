package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.systemMessage.ErrorMessage;
import java.util.List;

/**
 * 다리 건너기 게임의 다리를 의미하는 클래스
 */

public class Bridge {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    private final List<String> bridge;

    public Bridge(int size) {
        validateSize(size);
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public static int getBridgeMinSize() {
        return BRIDGE_MIN_SIZE;
    }

    public static int getBridgeMaxSize() {
        return BRIDGE_MAX_SIZE;
    }

    private void validateSize(int size) {
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_SIZE_ERROR.getMessage());
        }
    }

}
