package bridge.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeVerifierTest {
    BridgeSizeVerifier bridgeSizeVerifier = new BridgeSizeVerifier();

    @Nested
    @DisplayName("check 메소드 테스트")
    class Check {
        @ParameterizedTest
        @ValueSource(strings = {"a", "b", ".", " ", "\n", "!", "\\", "a2", "0a"})
        void 숫자가_아닌경우_예외처리_하는지_테스트(String target) {
            assertThatThrownBy(() -> bridgeSizeVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
        }

        @ParameterizedTest
        @ValueSource(strings = {"2200000000", "-2200000000"})
        void 정수형_범위를_넘어갈_때_예외처리_하는지_테스트(String target) {
            assertThatThrownBy(() -> bridgeSizeVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.OUT_OF_TYPE_RANGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "0", "-1", "21", "123021"})
        void 브리지_길이의_범위를_넘어설때_예외처리_하는지_테스트(String target) {
            assertThatThrownBy(() -> bridgeSizeVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE);
        }
    }
}