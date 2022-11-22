package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BridgeMakerTest {

    @Nested
    @DisplayName("다리의 모양을 올바르게 생성했는지 테스트")
    class makeBridge{
        BridgeNumberGenerator bridgeNumberGenerator;
        BridgeMaker bridgeMaker;
        @BeforeEach
        void setUp() {
            bridgeNumberGenerator = mock(BridgeRandomNumberGenerator.class);
            bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        }
        @Test
        void case1() {
            when(bridgeNumberGenerator.generate()).thenReturn(0,1,0,0,1);
            assertThat(bridgeMaker.makeBridge(5)).isEqualTo(List.of("D", "U", "D", "D", "U"));
        }

        @Test
        void case2() {
            when(bridgeNumberGenerator.generate()).thenReturn(1,0,1);
            assertThat(bridgeMaker.makeBridge(3)).isEqualTo(List.of("U", "D", "U"));
        }

        @Test
        void case3() {
            when(bridgeNumberGenerator.generate()).thenReturn(1,1,1,1,1);
            assertThat(bridgeMaker.makeBridge(5)).isEqualTo(List.of("U", "U", "U", "U", "U"));
        }

        @Test
        void case4() {
            when(bridgeNumberGenerator.generate()).thenReturn(0,0,0,0,0);
            assertThat(bridgeMaker.makeBridge(5)).isEqualTo(List.of("D", "D", "D", "D", "D"));
        }

        @Test
        void case5() {
            when(bridgeNumberGenerator.generate()).thenReturn(1,1,1,1,1,1,1,0,0,0,0,0,1,0,1,0,1,0,1,0);
            assertThat(bridgeMaker.makeBridge(20)).isEqualTo(List.of("U", "U", "U", "U", "U", "U", "U", "D", "D", "D", "D", "D", "U", "D", "U", "D", "U", "D", "U", "D"));
        }
    }
}