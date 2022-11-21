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

    @DisplayName("입력 길이에 맞는 다리를 생성한다.")
    @Nested
    class MakeBridge {

        @DisplayName("다리의 길이가 올바른지 확인")
        @Test
        void should_HaveCorrectLength_When_CreateBridge() {
            // given
            int inputLength = 7;
            // when
            List<String> bridge = bridgeMaker.makeBridge(inputLength);
            // then
            assertThat(bridge).hasSize(inputLength);
        }

        @DisplayName("다리가 올바른 요소를 가지고 있는지 확인")
        @Test
        void should_HaveCorrectMoving_When_CreateBridge() {
            // given
            int inputLength = 15;
            List<String> movingValues = List.of(UPPER_SIDE, LOWER_SIDE);
            // when
            boolean isMatch = true;
            List<String> bridge = bridgeMaker.makeBridge(inputLength);
            for (String moving: bridge) {
                if (!movingValues.contains(moving)) {
                    isMatch = false;
                }
            }
            // then
            assertThat(isMatch).isTrue();
        }

        @DisplayName("범위에 벗어난 다리 길이 입력 -> 예외 발생")
        @ValueSource(ints = {1, 25})
        @ParameterizedTest
        void should_ThrowIllegalArgumentException_When_GiveWrongBridgeSize(Integer input) {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}