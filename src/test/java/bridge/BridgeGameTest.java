package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.enums.InputConstants;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));

    static Stream<Arguments> moveDirectionAndTargetAndResult() {
        return Stream.of(
                Arguments.arguments(InputConstants.UP_MOVE.getValue(), 1, true),
                Arguments.arguments(InputConstants.UP_MOVE.getValue(), 0, true),
                Arguments.arguments(InputConstants.DOWN_MOVE.getValue(), 1, false),
                Arguments.arguments(InputConstants.UP_MOVE.getValue(), 2, false)
        );
    }

    static Stream<Arguments> gameCommandAndResult() {
        return Stream.of(
                Arguments.arguments(InputConstants.RETRY_GAME.getValue(), true),
                Arguments.arguments(InputConstants.QUIT_GAME.getValue(), false)
        );
    }

    static Stream<Arguments> blockIndexAndResult() {
        return Stream.of(
                Arguments.arguments(0, true),
                Arguments.arguments(1, true),
                Arguments.arguments(2, true),
                Arguments.arguments(3, false)
        );
    }


    @ParameterizedTest
    @MethodSource("moveDirectionAndTargetAndResult")
    @DisplayName("이동이 성공하면 true 실패하면 false를 반환한다.")
    void moveSuccess(String direction, int targetBlock, boolean result) {
        assertThat(bridgeGame.move(direction, targetBlock)).isEqualTo(result);
    }


    @ParameterizedTest
    @MethodSource("gameCommandAndResult")
    @DisplayName("게임이 재시작하면 true 중지하면 false를 반환한다.")
    void retryByInput(String gameCommand, boolean result) {
        assertThat(bridgeGame.retry(gameCommand)).isEqualTo(result);
    }


    @ParameterizedTest
    @MethodSource("blockIndexAndResult")
    @DisplayName("게임이 실행가능하면 true 불가능하면 false를 반환한다.")
    void executeGameByBlockIndex(int blockIndex, boolean result) {
        assertThat(bridgeGame.canExecute(blockIndex)).isEqualTo(result);
    }

}