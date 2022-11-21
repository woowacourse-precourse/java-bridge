package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {

    @DisplayName("사용자 칸 이동 테스트")
    @ParameterizedTest
    @CsvSource({"U, U, ' O |', '   |", "U, D, ' X |', '   |", "D, D, '   |', ' O |'", "D, U, '   |', ' X |"})
    void move2(String playerMove, String bridgeElement, String expected) {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> upSideDownSideMove = new ArrayList<>(List.of("", ""));
        CompareBridge move = new CompareBridge(playerMove);
        assertThat(bridgeGame.move(move, upSideDownSideMove, bridgeElement))
                .contains(expected);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(List.of(" O |   ", "  | X ")),
                Arguments.of(List.of(" O | O |  ", "  |  | X ")),
                Arguments.of(List.of(" X ", "  "))
        );
    }

    @DisplayName("게임 실패 여부 테스트")
    @ParameterizedTest
    @MethodSource("parameterProvider")
    void isFailure(List<String> upSideDownSideMove) {
        BridgeGame bridgeGame = new BridgeGame();
        boolean actual = bridgeGame.isFailure(upSideDownSideMove);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("총 시도한 횟수 테스트")
    @Test
    void retry() {
        assertSimpleTest(() -> {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.retry("R");
            assertEquals(2, BridgeGame.retryCount);
        });
    }
}