package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static bridge.domain.BridgeGameState.*;
import static bridge.domain.BridgeMoveType.DOWN;
import static bridge.domain.BridgeMoveType.UP;

class BridgeGameTest {

    private final BridgeGame bridgeGame;

    public BridgeGameTest() {
        this.bridgeGame = new BridgeGame(new BridgeGameRound(), new BridgePlayer(), new BridgeAnswer());
    }

    @ParameterizedTest
    @MethodSource("whenStartGameAndMoveThenSuccessDummy")
    @DisplayName("다리 길이를 넣어 게임을 시작하고 이동 타입을 이용한 플레이어 움직임 확인을 성공한다.")
    void whenStartGameAndMoveThenSuccessTest(int bridgeSize, List<BridgeMoveType> moveTypes) {
        // given
        bridgeGame.startGameWithBridgeSizeAs(bridgeSize);

        // when
        IntStream.range(0, moveTypes.size() - 1)
                        .forEach(moveTypeIndex -> bridgeGame.move(moveTypes.get(moveTypeIndex)));
        BridgeGameState gameState = bridgeGame.move(moveTypes.get(moveTypes.size() - 1));

        // then
        Assertions.assertThat(gameState).isIn(CONTINUE, FAIL, SUCCESS);
    }

    static Stream<Arguments> whenStartGameAndMoveThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(3, List.of(UP, DOWN)),
                Arguments.arguments(3, List.of(UP, DOWN, UP)),
                Arguments.arguments(5, List.of(UP, DOWN, UP)),
                Arguments.arguments(7, List.of(UP, UP, DOWN, UP)),
                Arguments.arguments(10, List.of(UP, UP, DOWN, DOWN, DOWN, UP, DOWN, UP, UP, DOWN))
        );
    }
}