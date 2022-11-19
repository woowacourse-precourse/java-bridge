package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @Test
    void makeBridgeTest() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for(int i=0; i<5; i++)
            System.out.println(bridgeRandomNumberGenerator.generate());

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        System.out.println(bridgeMaker.makeBridge(5));
    }
}
