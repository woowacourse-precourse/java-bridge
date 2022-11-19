package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 만들기 테스트: 랜덤으로 생성된 값에 따라 다리가 올바르게 생성되는지 테스트")
    void makeBridgeTest() {
        BridgeNumberGenerator mockGenerator = mock(BridgeRandomNumberGenerator.class);
        Mockito.when(mockGenerator.generate()).thenReturn(1, 0, 1, 0, 1, 1, 0);

        BridgeMaker bridgeMaker = new BridgeMaker(mockGenerator);
        int bridgeSize = 7;
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge).containsExactly("U", "D", "U", "D", "U", "U", "D");
        assertThat(bridge).size().isEqualTo(7);
    }
}
