package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @DisplayName("다리 입력 길이와 맞는 다리 생성")
    @Test
    void makeBridgeTest() {
        BridgeRandomNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Assertions.assertEquals(bridgeMaker.makeBridge(3).size(), 3);
    }
}
