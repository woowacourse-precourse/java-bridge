package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assumptions.*;

public class BridgeGameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        gameResult.putMovingResult();
    }

    @DisplayName("다리 칸 이동 결과를 저장한다.")
    @ParameterizedTest
    @CsvSource({"D,O", "U,O", "D,X", "U,X"})
    void putMovingResult(String shape, String upResult) {
        Direction direction = Direction.of(shape);
        MovingResult movingResult = MovingResultTest.of(upResult);

        gameResult.putMovingResult(direction, movingResult);
        assumingThat(direction == Direction.UP, () -> {
            assertThat(getResult(direction))
                    .containsExactly("O", "O", " ", movingResult.getResult());
        });
        assumingThat(direction == Direction.DOWN, () -> {
            assertThat(getResult(direction))
                    .containsExactly(" ", " ", "O",  movingResult.getResult());
        });
    }

    private List<String> getResult(Direction direction) {
        return gameResult.getMovingResultByDirection(direction).getResults()
            .stream()
            .map(MovingResult::getResult)
            .collect(Collectors.toList());
    }

    @DisplayName("다리 건너기 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateResultByShape")
    void getBridgeResultByShape(String shape, List<String> expected) {
        assertThat(getResult(Direction.of(shape)))
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateResultByShape() {
        return Stream.of(
                arguments("U", List.of("O", "O", " ")),
                arguments("D", List.of(" ", " ", "O"))
        );
    }

    @DisplayName("다리 건너기 결과를 초기화한다.")
    @Test
    void clearBridgeResult() {
        gameResult.clearResult();
        assertThat(gameResult.getMovingResultByDirection(Direction.UP).getResults()).isEmpty();
        assertThat(gameResult.getMovingResultByDirection(Direction.DOWN).getResults()).isEmpty();
    }

    static class GameResult extends BridgeGameResult {
        public void putMovingResult() {
            super.getMovingResultByDirection(Direction.UP).getResults()
                .addAll(List.of(MovingResult.SUCCESS, MovingResult.SUCCESS, MovingResult.NOTTING));
            super.getMovingResultByDirection(Direction.DOWN).getResults()
                .addAll(List.of(MovingResult.NOTTING, MovingResult.NOTTING, MovingResult.SUCCESS));
        }
    }

    static class MovingResultTest {
        public static MovingResult of(String result) {
            return Arrays.stream(MovingResult.values())
                .filter(movingResult -> movingResult.getResult().equals(result))
                .findFirst()
                .get();
        }
    }
}
