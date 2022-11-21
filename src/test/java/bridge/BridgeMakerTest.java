package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeMakerTest {

    private final static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();


    @DisplayName("다리 생성시 범위보다 작은 값이 입력되면 예외가 발생한다")
    @Test
    void makeBridgeOutOfRangeTest1() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = 2;

        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성시 범위보다 큰 값이 입력되면 예외가 발생한다")
    @Test
    void makeBridgeOutOfRangeTest2() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = 21;

        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성시 적절한 값이 입력되면 정상적으로 생성된다")
    @Test
    void makeBridgeSuccessTest() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = 3;

        // when
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        
        // then
        assertEquals(bridgeSize, bridge.size());
    }
}
