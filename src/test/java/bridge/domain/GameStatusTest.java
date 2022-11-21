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


class GameStatusTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("getGameHistory 메소드 테스트")
    class GetGameHistory {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 유저_입력_정보가_제대로_반환되는지_테스트(List<String> moveList, String expected) {
            GameUser gameUser = new GameUser();
            moveList.forEach(gameUser::move);

            GameStatus gameStatus = new GameStatus(gameUser);
            assertThat(gameStatus.getGameHistory()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of("U", "D", "U"), "[U, D, U]"),
                    Arguments.of(List.of("U"), "[U]"),
                    Arguments.of(List.of("U", "D", "U", "D", "D"), "[U, D, U, D, D]")
            );
        }
    }
}