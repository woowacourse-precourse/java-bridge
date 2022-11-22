package bridge;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @ParameterizedTest
    @DisplayName("다리 생성 TEST(다리 크기)")
    @ValueSource(ints = {3, 4, 5})
    void checkBridgeSize(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertEquals(bridge.size(), size);
    }

    @ParameterizedTest
    @DisplayName("다리 생성 TEST(U칸과 D칸 생성)")
    @ValueSource(ints = 3)
    void checkBridge(int size) {
        List<String> bridgeList = List.of("U", "D");
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertTrue(bridgeList.containsAll(bridge));

    }
}
