package bridge.bridgeMaker;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {

    @DisplayName("입력 사이즈에 따른 다리 생성 테스트")
    @ValueSource(ints = {3, 5, 10, 20})
    @ParameterizedTest
    void makeBridgeTest(Integer size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        List<String> caseOfBridges = new ArrayList<>();
        createBridgeCase(caseOfBridges, new ArrayList<>(), size);
        assertThat(caseOfBridges.contains(madeBridge.toString())).isTrue();
    }

    void createBridgeCase(List<String> caseOfBridges, List<String> bridge, int size) {
        if (bridge.size() == size) {
            caseOfBridges.add(bridge.toString());
            return;
        }
        bridge.add("U");
        createBridgeCase(caseOfBridges, bridge, size);
        bridge.set(bridge.size() - 1, "D");
        createBridgeCase(caseOfBridges, bridge, size);
        bridge.remove(bridge.size()-1);
    }
}
