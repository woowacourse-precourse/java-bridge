package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    static BridgeMaker bridgeMaker;

    @BeforeAll
    static void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    @DisplayName("원하는 크기로 다리가 제대로 만들어졌는지 테스트")
    void bridge_size_is_desired_size(Integer desiredSize) {
        // given

        // when
        List<String> bridge = bridgeMaker.makeBridge(desiredSize);

        // then
        assertThat(bridge.size()).isEqualTo(desiredSize);
    }

    @Nested
    @DisplayName("다리를 만들 때")
    class When_create_bridge {

        @ParameterizedTest
        @ValueSource(ints = {1, 30})
        @DisplayName("게임 규칙 범위 밖이면 예외를 던진다")
        void exception_is_thrown_if_outside_range_set_by_rule(Integer desiredSize) {
            // given

            // when, then
            assertThatThrownBy(() -> bridgeMaker.makeBridge(desiredSize))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BRIDGE_SIZE_MUST_BE_FROM_THREE_TO_TWENTY.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 10, 20})
        @DisplayName("게임 규칙 범위 안이면 예외를 던진다")
        void exception_is_not_thrown_inside_range_set_by_rule(Integer desiredSize) {
            // given

            // when, then
            assertThatCode(() -> bridgeMaker.makeBridge(desiredSize))
                    .doesNotThrowAnyException();
        }
    }
}