package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {
    private static BridgeGame game;

    @BeforeEach
    void setUp() {
        BridgeLength bridgeLength = new BridgeLength(5);
        List<Integer> testNumbers = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0));
        TestNumberGenerator numberGenerator = new TestNumberGenerator(testNumbers);

        game = new BridgeGame(bridgeLength, numberGenerator);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {
        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

    @Test
    @DisplayName("이전 라운드가 실패인 경우 다음 라운드를 진행하지 못한다")
    void moveThrowsErrorWhenPreviousRoundHasFailed() {
        game.move(1, BridgeMove.DOWN);
        game.move(2, BridgeMove.DOWN);
        assertThatThrownBy(() -> game.move(3, BridgeMove.UP))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이전 라운드가 성공한 경우에만 다음 라운드를 진행할 수 있습니다");
    }

    @ParameterizedTest(name = "잘못된 인자는 예외를 발생시킨다.")
    @MethodSource
    void moveThrowsError(int round, BridgeMove move, Class<Exception> exception, String errorMessage) {
        assertThatThrownBy(() -> game.move(round, move))
                .isInstanceOf(exception)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> moveThrowsError() {
        return Stream.of(
                Arguments.of(2, BridgeMove.UP, IndexOutOfBoundsException.class, "round는 이전 round + 1이어야 합니다."),
                Arguments.of(0, BridgeMove.UP, IndexOutOfBoundsException.class, "round는 이전 round + 1이어야 합니다."),
                Arguments.of(1, null, NullPointerException.class, "move는 null이 될 수 없습니다.")
        );
    }

    @ParameterizedTest(name = "선택한 방향이 이동가능한 방향이면 이동한다")
    @MethodSource
    void move(int round, BridgeMove move, boolean moved) {
        assertThat(game.move(round, move)).isEqualTo(moved);
        assertThat(game.getResult().getTrialResult(1).getTotalRound()).isEqualTo(round);
    }

    private static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(1, BridgeMove.UP, false),
                Arguments.of(1, BridgeMove.DOWN, true)
        );
    }

    @Test
    @DisplayName("다리 끝까지 이동한다")
    void crossTheBridge() {
        List<BridgeMove> moves = List.of(BridgeMove.DOWN, BridgeMove.UP, BridgeMove.UP, BridgeMove.UP, BridgeMove.DOWN);
        for (int round = 1; round <= moves.size(); round++) {
            assertThat(game.move(round, moves.get(round - 1))).isTrue();
        }
        assertThat(game.getResult().getTrialResult(1).didCrossedBridge(game.getLength())).isTrue();
    }

    private static Stream<Arguments> corssTheBridge() {
        return Stream.of(
                Arguments.of(1, BridgeMove.DOWN, true),
                Arguments.of(2, BridgeMove.UP, true),
                Arguments.of(3, BridgeMove.UP, true),
                Arguments.of(4, BridgeMove.UP, true),
                Arguments.of(5, BridgeMove.DOWN, true)
        );
    }

    @Test
    @DisplayName("새로운 시도를 시작한다")
    void retry() {
        int totalTrialbeforeRetry = game.getResult().getTotalTrial();
        game.retry();
        int totalTrialAfterRetry = game.getResult().getTotalTrial();
        assertThat(totalTrialAfterRetry).isEqualTo(totalTrialbeforeRetry + 1);
    }
}