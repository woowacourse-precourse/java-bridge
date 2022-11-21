package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


class GameUserTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("move 메소드 테스트")
    class Move {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 유저의_위치가_잘_이동하는지_테스트(String expected, List<String> target) {
            GameUser gameUser = new GameUser();
            for (String moving : target) {
                gameUser.move(moving);
            }
            assertThat(gameUser.toString()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of("[]", List.of()),
                    Arguments.of("[U]", List.of("U")),
                    Arguments.of("[D]", List.of("D")),
                    Arguments.of("[U, D, U]", List.of("U", "D", "U")),
                    Arguments.of("[U, U, U, U, U, D]", List.of("U", "U", "U", "U", "U", "D")),
                    Arguments.of("[D, D, D, D]", List.of("D", "D", "D", "D"))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isGetOutFrom 메소드 테스트")
    class GetOffFrom {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 유저가_다리에서_벗어났는지_반환하는_기능을_테스트(List<String> userBridge, Bridge targetBridge) {
            GameUser gameUser = new GameUser();
            for (String moving : userBridge) {
                gameUser.move(moving);
            }

            assertThat(gameUser.isGetOutFrom(targetBridge)).isTrue();
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of("U"), new Bridge(List.of("D"))),
                    Arguments.of(List.of("D"), new Bridge(List.of("U"))),
                    Arguments.of(List.of("U", "D", "U"), new Bridge(List.of("U", "D", "D"))),
                    Arguments.of(List.of("U", "D", "U", "U"), new Bridge(List.of("U", "D", "U", "D")))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isOnTheFinalBlockOf 메소드 테스트")
    class IsOnTheFinalBlock {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 유저가_다리의_마지막_블록에_있는지_반환하는_기능을_테스트(List<String> userBridge, Bridge targetBridge) {
            GameUser gameUser = new GameUser();
            for (String moving : userBridge) {
                gameUser.move(moving);
            }

            assertThat(gameUser.isOnTheFinalBlockOf(targetBridge)).isTrue();
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of("U"), new Bridge(List.of("U"))),
                    Arguments.of(List.of("D"), new Bridge(List.of("D"))),
                    Arguments.of(List.of("U", "D", "U"), new Bridge(List.of("U", "D", "U"))),
                    Arguments.of(List.of("U", "D", "U", "U"), new Bridge(List.of("U", "D", "U", "U")))
            );
        }
    }
}