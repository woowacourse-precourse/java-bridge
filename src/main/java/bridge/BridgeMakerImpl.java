package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bridge.Space.*;

public class BridgeMakerImpl {
    private static final String HEAD_OF_BRIDGE = "[";
    private static final String TAIL_OF_BRIDGE = "]";

    // 게임 시작 전 초기 다리 생성
    public UsersBridgeCrossStatus makeInitialBridge(int size) {
        List<List<String>> newBridge = new ArrayList<>();
        List<String> initialUpSpace = new ArrayList<>();
        initialUpSpace.add(HEAD_OF_BRIDGE);
        initialUpSpace.add(TAIL_OF_BRIDGE);
        List<String> initialDownSpace = new ArrayList<>(initialUpSpace);
        newBridge.add(DOWN.getIndex(), initialUpSpace);
        newBridge.add(UP.getIndex(), initialDownSpace);

        return new UsersBridgeCrossStatus(newBridge, size);
    }

    public List<String> makeAnswerBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }
}
