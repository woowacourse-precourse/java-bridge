package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
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
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
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
        assertThat(gameState).isIn(CONTINUE, FAIL, SUCCESS);
    }

    @ParameterizedTest
    @MethodSource("whenPlayerMoveMoreThanAnswerBridgeThenExceptionDummy")
    @DisplayName("플레이어가 다리 정답 길이보다 더 많이 움직일 때 실패하여 예외처리한다.")
    void whenPlayerMoveMoreThanAnswerBridgeThenExceptionTest(int bridgeSize, List<BridgeMoveType> moveTypes) {
        bridgeGame.startGameWithBridgeSizeAs(bridgeSize);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> moveTypes.forEach(bridgeGame::move));
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

    static Stream<Arguments> whenPlayerMoveMoreThanAnswerBridgeThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(3, List.of(UP, DOWN, DOWN, DOWN)),
                Arguments.arguments(3, List.of(UP, DOWN, UP, UP, UP, UP, UP)),
                Arguments.arguments(5, List.of(UP, DOWN, UP, UP, UP, UP, UP, UP)),
                Arguments.arguments(7, List.of(UP, UP, DOWN, UP, UP, UP, UP, UP, UP, UP, UP, UP, UP, UP)),
                Arguments.arguments(10, List.of(UP, UP, DOWN, DOWN, DOWN, UP, DOWN, UP, UP, UP, UP))
        );
    }
}