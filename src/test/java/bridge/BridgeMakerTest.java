package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("랜덤으로 다리를 생성한다.")
    @Test
    void makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        System.out.println(bridgeMaker.makeBridge(5).toString());
    }
}