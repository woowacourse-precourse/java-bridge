package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.constant.Direction;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BridgeGameTest {
    @ParameterizedTest
    @DisplayName("플레이어의 칸과 다리의 칸을 비교하여 다리 건너기 결과값을 반환한다.")
    @MethodSource("provideParametersForComparison")
    void comparePlayerAndBridgePosition(String player, String bridge, Direction direction, String result) {
        assertThat(new BridgeGame().comparePosition(player, bridge, direction)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForComparison() {
        return Stream.of(
                Arguments.of("U", "U", Direction.UP, "O"),
                Arguments.of("U", "D", Direction.UP, "X"),
                Arguments.of("D", "D", Direction.UP, " "),
                Arguments.of("D", "U", Direction.UP, " "),
                Arguments.of("U", "U", Direction.DOWN, " "),
                Arguments.of("U", "D", Direction.DOWN, " "),
                Arguments.of("D", "D", Direction.DOWN, "O"),
                Arguments.of("D", "U", Direction.DOWN, "X")
        );
    }

    @ParameterizedTest
    @DisplayName("플레이어가 이동할 수 없는 칸으로 이동했는지 확인한다.")
    @MethodSource("provideParametersForCorrectMove")
    void playerCannotCross(List<String> moves, List<String> bridge, boolean result) {
        assertThat(new BridgeGame().hasMadeCorrectMove(moves, bridge)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForCorrectMove() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D"), List.of("U", "U", "D"), true),
                Arguments.of(List.of("U"), List.of("U", "U", "D"), true),
                Arguments.of(List.of("U", "U"), List.of("U", "D", "D"), false),
                Arguments.of(List.of("U", "U", "D"), List.of("U", "U", "U"), false)

        );
    }
}
