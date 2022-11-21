package bridge;

import bridge.domain.model.Direction;
import bridge.domain.model.GameStatus;
import bridge.config.InvalidMoveException;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("성공적으로 모든 칸을 이동했을 때")
    @ParameterizedTest
    @MethodSource("generateWinMoves")
    public void gameMoveWinTest(List<String> bridgeInput, List<String> moveDirections) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeInput));
        moveDirections.forEach(d -> bridgeGame.move(Direction.of(d)));
        assertThat(bridgeGame.getStatus()).isEqualTo(GameStatus.WIN);
    }

    @DisplayName("이동에 실패하여 게임에 패배하였을 때")
    @ParameterizedTest
    @MethodSource("generateFailMoves")
    public void gameMoveFailTest(List<String> bridgeInput, List<String> moveDirections) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeInput));
        moveDirections.forEach(d -> bridgeGame.move(Direction.of(d)));
        assertThat(bridgeGame.getStatus()).isEqualTo(GameStatus.LOSE);
    }

    @DisplayName("이동에 실패한 후 더 이동을 시도하는 경우 예외 처리")
    @ParameterizedTest
    @MethodSource("generateMovesAfterFail")
    public void gameMoveAfterFailTest(List<String> bridgeInput, List<String> moveDirections) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeInput));
        assertThatThrownBy(
                () -> moveDirections.forEach(d -> bridgeGame.move(Direction.of(d)))
        ).isInstanceOf(InvalidMoveException.class);
    }

    @DisplayName("게임에 승리한 이후 더 이동을 시도하는 경우 예외 처리")
    @ParameterizedTest
    @MethodSource("generateMovesAfterWin")
    public void gameMoveAfterWinTest(List<String> bridgeInput, List<String> moveDirections) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeInput));
        assertThatThrownBy(
                () -> moveDirections.forEach(d -> bridgeGame.move(Direction.of(d)))
        ).isInstanceOf(InvalidMoveException.class);
    }

    @DisplayName("이동에 실패한 후 재시작하는 경우 상태 초기화")
    @Test
    public void gameRetryTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "D", "D")));
        bridgeGame.move(Direction.DOWN);
        assertThat(bridgeGame.getStatus()).isEqualTo(GameStatus.LOSE);
        bridgeGame.retry();
        assertThat(bridgeGame.getStatus()).isEqualTo(GameStatus.RUNNING);
    }

    private static Stream<Arguments> generateWinMoves() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "D", "U"), Arrays.asList("U", "U", "D", "U")),
                Arguments.of(Arrays.asList("D", "U", "D", "D", "U"), Arrays.asList("D", "U", "D", "D", "U")),
                Arguments.of(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"))
        );
    }

    private static Stream<Arguments> generateFailMoves() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "D", "U"), Arrays.asList("U", "U", "U")),
                Arguments.of(Arrays.asList("D", "U", "D", "D", "U"), Arrays.asList("U")),
                Arguments.of(Arrays.asList("U", "U", "U"), Arrays.asList("U", "D"))
        );
    }

    private static Stream<Arguments> generateMovesAfterFail() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "D", "U"), Arrays.asList("U", "U", "U", "U")),
                Arguments.of(Arrays.asList("D", "U", "D", "D", "U"), Arrays.asList("U", "U")),
                Arguments.of(Arrays.asList("U", "U", "U"), Arrays.asList("U", "D", "U"))
        );
    }

    private static Stream<Arguments> generateMovesAfterWin() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "D", "U"), Arrays.asList("U", "U", "D", "U", "U")),
                Arguments.of(Arrays.asList("D", "U", "D", "D", "U"), Arrays.asList("D", "U", "D", "D", "U", "D")),
                Arguments.of(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U", "D"))
        );
    }

}
