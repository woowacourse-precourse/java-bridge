package bridge.bridgemaking;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;

import java.util.ArrayList;
import java.util.List;

public class BridgeMakerImpl {
    private static final String HEAD_OF_BRIDGE = "[";
    private static final String TAIL_OF_BRIDGE = "]";

    public User makeNewUser(int bridgeSize) {
        List<List<String>> madeBridge = makeInitialBridge();
        return new User(madeBridge, bridgeSize);
    }

    // 다리 리스트에 "["와 "]" 추가
    public static List<List<String>> makeInitialBridge() {
        List<String> bridgeStructure = new ArrayList<>(List.of(HEAD_OF_BRIDGE, TAIL_OF_BRIDGE));
        List<List<String>> madeBridge = new ArrayList<>();

        madeBridge.add(new ArrayList<>(bridgeStructure));
        madeBridge.add(new ArrayList<>(bridgeStructure));
        return madeBridge;
    }

    public List<String> makeAnswerBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
