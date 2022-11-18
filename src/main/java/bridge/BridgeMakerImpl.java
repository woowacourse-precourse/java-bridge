package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bridge.Space.*;

public class BridgeMakerImpl {
    private static final String HEAD_OF_BRIDGE = "[";
    private static final String TAIL_OF_BRIDGE = "]";

    // 게임 시작 전 초기 다리 생성
    public UsersBridgeCrossStatus makeInitialBridge(int length) {
        List<List<String>> newBridge = new ArrayList<>();

        List<String> initialBridgeShape = Arrays.asList(HEAD_OF_BRIDGE, TAIL_OF_BRIDGE);
        newBridge.add(DOWN.getIndex(), initialBridgeShape);
        newBridge.add(UP.getIndex(), initialBridgeShape);

        return new UsersBridgeCrossStatus(newBridge, length);
    }

    public List<String> makeAnswerBridge(int length) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(length);
    }
}
