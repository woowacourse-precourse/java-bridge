package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.constant.GameCommand;
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
    void comparePlayerAndBridgePosition(String player, String bridge, GameCommand direction, String result) {
        assertThat(new BridgeGame().comparePosition(player, bridge, direction)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForComparison() {
        return Stream.of(
                Arguments.of("U", "U", GameCommand.UP, "O"),
                Arguments.of("U", "D", GameCommand.UP, "X"),
                Arguments.of("D", "D", GameCommand.UP, " "),
                Arguments.of("D", "U", GameCommand.UP, " "),
                Arguments.of("U", "U", GameCommand.DOWN, " "),
                Arguments.of("U", "D", GameCommand.DOWN, " "),
                Arguments.of("D", "D", GameCommand.DOWN, "O"),
                Arguments.of("D", "U", GameCommand.DOWN, "X")
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

    @ParameterizedTest
    @DisplayName("플레이어 이동 횟수와 다리 길이를 비교한다.")
    @MethodSource("provideParametersForEnd")
    void movesAndBridgeSameSize(List<String> moves, List<String> bridge, boolean result) {
        assertThat(new BridgeGame().areSameSize(moves, bridge)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForEnd() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D"), List.of("U", "U", "D"), true),
                Arguments.of(List.of("U"), List.of("U", "U", "D"), false),
                Arguments.of(List.of("U", "U"), List.of("U", "D", "D"), false),
                Arguments.of(List.of("U", "U", "D"), List.of("U", "U", "U"), true)

        );
    }
}
