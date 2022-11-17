package bridge;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    @ParameterizedTest
    @DisplayName("다리 생성 TEST(다리 크기)")
    @ValueSource(ints = {3, 4, 5})
    void checkBridgeSize(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker =new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertEquals(bridge.size(),size);
    }
}
