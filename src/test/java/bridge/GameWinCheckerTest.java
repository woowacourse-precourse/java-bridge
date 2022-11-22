package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameWinCheckerTest {

    private GameWinChecker gameWinChecker;

    @BeforeEach
    public void init() {
        gameWinChecker = new GameWinChecker();
    }

    @DisplayName("승리 조건인 경우 true")
    @Test
    public void checkWinCase() {
        Deque<MovementStatusForm> movementStatusResult = new LinkedList<>(List.of(MovementStatusForm.UP_O
                , MovementStatusForm.UP_O
                , MovementStatusForm.UP_O
                , MovementStatusForm.UP_O));

        assertThat(gameWinChecker.isWin(movementStatusResult, 4)).isTrue();
    }

    @DisplayName("승리 조건이 아닌 경우 false")
    @ParameterizedTest
    @MethodSource("parameterProviderForNotWinCase")
    public void checkNotWinCase(Deque<MovementStatusForm> movementStatusResult) {

        assertThat(gameWinChecker.isWin(movementStatusResult, 4)).isFalse();
    }

    private static Stream<Arguments> parameterProviderForNotWinCase() {
        return Stream.of(
                Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_O
                        , MovementStatusForm.UP_O
                        , MovementStatusForm.UP_O
                        , MovementStatusForm.UP_X)))
                , Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_X)))
                , Arguments.arguments(new LinkedList<>(List.of(MovementStatusForm.UP_O)))
        );
    }

}