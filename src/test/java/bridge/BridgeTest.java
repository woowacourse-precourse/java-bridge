package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("각 라운드에 다리의 표시에 맞게 움직임이 주어지면 O를 반환한다.")
    @MethodSource("movingOnEachRound")
    @ParameterizedTest
    void 각_라운드에_다리의_표시에_맞게_움직일_경우(String moving, int round) {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U", "D"));
        String rightAnswer = "O";

        // when
        String resultOfMoving = bridge.isCorrectMoving(moving, round);

        // then
        assertThat(resultOfMoving).isEqualTo(rightAnswer);
    }

    @DisplayName("각 라운드에 다리의 표시와 다르게 움직이 주어지면 X를 반환한다.")
    @MethodSource("movingOnEachRound")
    @ParameterizedTest
    void 각_라운드에_다리의_표시와_다르게_움직일_경우(String moving, int round) {
        // given
        Bridge bridge = new Bridge(List.of("D", "U", "D", "D", "U"));
        String wrongAnswer = "X";

        // when
        String resultOfMoving = bridge.isCorrectMoving(moving, round);

        // then
        assertThat(resultOfMoving).isEqualTo(wrongAnswer);
    }

    private static Stream<Arguments> movingOnEachRound() {
        return Stream.of(
                Arguments.of("U", 0),
                Arguments.of("D", 1),
                Arguments.of("U", 2),
                Arguments.of("U", 3),
                Arguments.of("D", 4)
        );
    }
}