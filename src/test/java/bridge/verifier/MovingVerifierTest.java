package bridge.verifier;

import bridge.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingVerifierTest {
    MovingVerifier movingVerifier = new MovingVerifier();

    @Nested
    @DisplayName("check 메소드 테스트")
    class Check {
        @ParameterizedTest
        @ValueSource(strings = {"1", "2", ".", " ", "\n", "!", "\\", "a2", "0a"})
        void 알파벳이_아닌경우_예외처리_하는지_테스트(String target) {
            assertThatThrownBy(() -> movingVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_ALPHABETIC);
        }

        @ParameterizedTest
        @ValueSource(strings = {"A", "B", "C", "Z", "a", "e"})
        void 정해진_값_이외에는_예외처리_하는지_테스트(String target) {
            assertThatThrownBy(() -> movingVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_UNDERSTANDABLE_COMMAND);
        }
    }
}