package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameOverCheckerTest {

    GameOverChecker gameOverChecker;


    @BeforeEach
    public void init() {
        gameOverChecker = new GameOverChecker();
    }

    @DisplayName("종료 조건 미 부합시 false")
    @ParameterizedTest
    @MethodSource("parameterProviderForFalseCase")
    public void checkGameOverFalseCase(Deque<MovementStatusForm> movementResult) {
        assertThat(gameOverChecker.isOver(movementResult, 3)).isFalse();
    }

    private static Stream<Arguments> parameterProviderForFalseCase() {
        return Stream.of(
                Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.DOWN_O)))
                , Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_O, MovementStatusForm.DOWN_O)))
        );
    }

    @DisplayName("종료 조건 부합 시 true")
    @ParameterizedTest
    @MethodSource("parameterProviderForTrueCase")
    public void checkGameOverTrueCase(Deque<MovementStatusForm> movementResult) {
        assertThat(gameOverChecker.isOver(movementResult, 2)).isTrue();
    }

    private static Stream<Arguments> parameterProviderForTrueCase() {
        return Stream.of(
                Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_O, MovementStatusForm.UP_O)))
                , Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_O, MovementStatusForm.UP_X)))
                , Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_X)))
        );
    }

}