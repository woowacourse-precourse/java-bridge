package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("다리 생성 테스트")
    public void makeBridgeTest() {
        // given
        int size = 3;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("getDirection 테스트")
    public void getDirectionTest() {
        // given
        int number = 0;

        // when
        String result1 = bridgeMaker.getDirection(0);
        String result2 = bridgeMaker.getDirection(1);

        // then
        assertThat(result1).isEqualTo("D");
        assertThat(result2).isEqualTo("U");

    }
}
