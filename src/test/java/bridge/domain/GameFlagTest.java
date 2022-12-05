package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GameFlagTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("getMessage 메소드 테스트")
    class GetMessage {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 플래그에_맞는_메세지를_잘_반환하는지_테스트(GameFlag target, String expected) {
            assertThat(target.getMessage()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(GameFlag.CLEAR, "성공"),
                    Arguments.of(GameFlag.FAIL, "실패"),
                    Arguments.of(GameFlag.PLAYING, "게임 진행중")
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isClear 메소드 테스트")
    class IsClear {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 플래그가_clear를_내포하는지_테스트(GameFlag target, boolean expected) {
            assertThat(target.isClear()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(GameFlag.CLEAR, true),
                    Arguments.of(GameFlag.FAIL, false),
                    Arguments.of(GameFlag.PLAYING, false)
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isFail 메소드 테스트")
    class IsFail {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 플래그가_fail을_내포하는지_테스트(GameFlag target, boolean expected) {
            assertThat(target.isFail()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(GameFlag.CLEAR, false),
                    Arguments.of(GameFlag.FAIL, true),
                    Arguments.of(GameFlag.PLAYING, false)
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isPlaying 메소드 테스트")
    class IsPlaying {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 플래그가_playing을_내포하는지_테스트(GameFlag target, boolean expected) {
            assertThat(target.isPlaying()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(GameFlag.CLEAR, false),
                    Arguments.of(GameFlag.FAIL, false),
                    Arguments.of(GameFlag.PLAYING, true)
            );
        }
    }
}