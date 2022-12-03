package bridge.constant;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeRuleTest {

    @Nested
    @DisplayName("다리 크기를 입력 받을 때")
    class When_receive_bridge_size {

        @ParameterizedTest
        @ValueSource(ints = {1, 30})
        @DisplayName("게임 규칙 범위 밖이면 예외를 던진다")
        void exception_is_thrown_if_outside_range_set_by_rule(Integer desiredSize) {
            // given

            // when, then
            assertThatThrownBy(() -> BridgeSizeRule.validateBridgeSize(desiredSize))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BRIDGE_SIZE_MUST_BE_FROM_THREE_TO_TWENTY.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 10, 20})
        @DisplayName("게임 규칙 범위 안이면 예외를 던진다")
        void exception_is_not_thrown_inside_range_set_by_rule(Integer desiredSize) {
            // given

            // when, then
            assertThatCode(() -> BridgeSizeRule.validateBridgeSize(desiredSize))
                    .doesNotThrowAnyException();
        }
    }
}