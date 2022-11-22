package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    static BridgeMaker bridgeMaker;

    @BeforeAll
    static void initAll() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("크기 1의 bridge 를 생성하면, U 혹은 D 가 bridge 에 포함되어 있다.")
    @Test
    void makeBridgeTest1() {
        List<String> bridge = bridgeMaker.makeBridge(1);
        boolean result = bridge.contains("D") | bridge.contains("U");
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("생성된 bridge 의 크기가 매개변수로 준 size 와 동일하다.")
    @Test
    void makeBridgeTest2() {
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }
}