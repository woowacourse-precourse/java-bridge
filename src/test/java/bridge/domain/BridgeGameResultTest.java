package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assumptions.*;

public class BridgeGameResultTest {
    private static final String UP_SIDE_SHAPE = "U";
    private static final String DOWN_SIDE_SHAPE = "D";
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        gameResult.putMovingResult();
    }

    @DisplayName("다리 칸 이동 결과를 저장한다.")
    @ParameterizedTest
    @CsvSource({"D,O", "U,O", "D,X", "U,X"})
    void putMovingResult(String shape, String movingResult) {
        gameResult.putMovingResult(shape, movingResult);
        assumingThat(shape.equals(UP_SIDE_SHAPE), () -> {
            assertThat(gameResult.getBridgeByShape(shape))
                    .containsExactly("O", "O", " ", " ", " ", movingResult);
        });
        assumingThat(shape.equals(DOWN_SIDE_SHAPE), () -> {
            assertThat(gameResult.getBridgeByShape(shape))
                    .containsExactly(" ", " ", "O", "O", "O",  movingResult);
        });
    }

    @DisplayName("다리 건너기 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateResultByShape")
    void getBridgeResultByShape(String shape, List<String> expected) {
        assertThat(gameResult.getBridgeByShape(shape))
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateResultByShape() {
        return Stream.of(
                arguments("U", List.of("O", "O", " ", " ", " ")),
                arguments("D", List.of(" ", " ", "O", "O", "O"))
        );
    }

    @DisplayName("다리 건너기 결과를 초기화한다.")
    @Test
    void clearBridgeResult() {
        gameResult.clearResult();
        assertThat(gameResult.getBridgeByShape(UP_SIDE_SHAPE)).isEmpty();
        assertThat(gameResult.getBridgeByShape(DOWN_SIDE_SHAPE)).isEmpty();
    }

    static class GameResult extends BridgeGameResult {
        public void putMovingResult() {
            super.getBridgeByShape(UP_SIDE_SHAPE).addAll(List.of("O", "O", " ", " ", " "));
            super.getBridgeByShape(DOWN_SIDE_SHAPE).addAll(List.of(" ", " ", "O", "O", "O"));
        }
    }
}
