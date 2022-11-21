package bridge;

import bridge.mock.MockNumberGenerator;
import bridge.vo.enums.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    public static final String DOWN = Step.D.toString();
    public static final String UP = Step.U.toString();

    @Nested
    @DisplayName("입력받은 갈이를 가진 다리를 생성하는 makeBridge 메서드")
    class makeBridge {
        @Test
        @DisplayName("생성한 다리의 길이는 입력값 만큼의 길이를 가지고 있다.")
        void whenBridgeSize_whenMakingBridge_thenMakesBridgeHavingGivenSize() {
            //given
            int bridgeSize = 4;
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

            //when
            List<String> target = bridgeMaker.makeBridge(bridgeSize);

            //then
            assertThat(target).hasSize(bridgeSize);
        }

        @Test
        @DisplayName("만들어진 다리는 위, 아래 칸을 나타내는 U와 D로만 이루어져 있다.")
        void whenBridgeSize_whenMakingBridge_thenMakesBridgeHavingOnlyUAndD() {
            //given
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

            //when
            List<String> target = bridgeMaker.makeBridge(10);

            //then
            assertThat(target).containsOnly(UP, DOWN);
        }

        @Test
        @DisplayName("BridgeGenerator 에서 만든 숫자에 해당하는 U 또는 D의 대문자로 적절히 바꾸어 다리를 만든다.")
        void givenBridgeNumbers_whenMakingBridge_thenMakesBridgeHavingMatchingUpperCase() {
            //given
            BridgeMaker bridgeMaker = getMockBridgeMaker(List.of(0, 1, 0, 0, 1, 1, 1, 0));

            //when
            List<String> target = bridgeMaker.makeBridge(8);

            //then
            assertThat(target).containsExactly(DOWN, UP, DOWN, DOWN, UP, UP, UP, DOWN);
        }
    }

    private static BridgeMaker getMockBridgeMaker(List<Integer> mockValue) {
        return new BridgeMaker(
                getMockNumberGenerator(mockValue)
        );
    }

    private static MockNumberGenerator getMockNumberGenerator(List<Integer> mockValues) {
        return new MockNumberGenerator(mockValues);
    }
}