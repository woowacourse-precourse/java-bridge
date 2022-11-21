package bridge;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private static BridgeNumberGenerator bridgeNumberGenerator;
    private static BridgeMaker bridgeMaker;

    @BeforeAll
    static void init(){
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @Test
    @DisplayName("정상적으로 다리가 생성되는 지 확인")
    void 다리생성(){
        List<String> bridge = new ArrayList<>();
        bridge = bridgeMaker.makeBridge(10);
        System.out.println(bridge);
        org.assertj.core.api.Assertions.assertThat(bridge.toString().contains("U"));
        org.assertj.core.api.Assertions.assertThat(bridge.toString().contains("D"));
    }

}