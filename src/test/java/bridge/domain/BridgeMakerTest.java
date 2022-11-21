package bridge.domain;

import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> movingValues = List.of(UPPER_SIDE, LOWER_SIDE);

    @DisplayName("입력 길이에 맞는 다리를 생성한다.")
    @Nested
    class MakeBridge {

        @DisplayName("다리의 길이가 올바른지 확인")
        @Test
        void should_HaveCorrectLength_When_CreateBridge() {
            int inputLength = 7;
            List<String> bridge = bridgeMaker.makeBridge(inputLength);
            assertThat(bridge).hasSize(inputLength);
        }

        @DisplayName("다리가 올바른 요소를 가지고 있는지 확인")
        @Test
        void should_HaveCorrectMoving_When_CreateBridge() {
            List<String> bridge = bridgeMaker.makeBridge(20);
            for (String moving: bridge) {
                assertThat(moving).isIn(movingValues);
            }
        }

        @DisplayName("범위에 벗어난 다리 길이 입력 -> 예외 발생")
        @ValueSource(ints = {1, 25, -3})
        @ParameterizedTest
        void should_ThrowIllegalArgumentException_When_GiveWrongBridgeSize(Integer input) {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}