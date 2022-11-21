package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class GameControlTest {

    @Nested
    @DisplayName("isQuit 메소드 테스트")
    class IsQuit {
        @ParameterizedTest
        @ValueSource(strings = {"Q"})
        void 입력이_Q이면_참을_반환하는지_테스트(String target) {
            assertThat(GameControl.isQuit(target)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(strings = {"A", "R", "r", "1", "#", " ", "\n"})
        void 입력이_Q가_아니면_거짓을_반환하는지_테스트(String target) {
            assertThat(GameControl.isQuit(target)).isFalse();
        }
    }

    @Nested
    @DisplayName("isRetry 메소드 테스트")
    class IsRetry {
        @ParameterizedTest
        @ValueSource(strings = {"R"})
        void 입력이_R이면_참을_반환하는지_테스트(String target) {
            assertThat(GameControl.isRetry(target)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(strings = {"A", "Q", "q", "1", "#", " ", "\n"})
        void 입력이_R이_아니면_거짓을_반환하는지_테스트(String target) {
            assertThat(GameControl.isRetry(target)).isFalse();
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("toString 메소드 테스트")
    class ToString {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 커맨드에_따라_올바른_키를_반환하는지_테스트(GameControl target, String expected) {
            assertThat(target.toString()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(GameControl.QUIT, "Q"),
                    Arguments.of(GameControl.RETRY, "R")
            );
        }
    }
}