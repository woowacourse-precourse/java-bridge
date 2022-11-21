package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.BridgeGameState.*;
import static bridge.domain.BridgeMoveType.DOWN;
import static bridge.domain.BridgeMoveType.UP;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeAnswerTest {

    @ParameterizedTest(name = "[{index}] - moveTypes = {0}")
    @MethodSource("whenCompareBridgeThenSuccessDummy")
    @DisplayName("두 다리를 비교해서 게임 상태 반환 확인을 성공한다.")
    void whenCompareBridgeThenSuccessTest(List<BridgeMoveType> moveTypes) {
        // given
        BridgeAnswer bridgeAnswer = new BridgeAnswer();
        BridgePlayer bridgePlayer = new BridgePlayer();
        moveTypes.forEach(bridgePlayer::moveTo);

        //  when
        bridgeAnswer.setUpAnswerSizeBy(moveTypes.size());
        BridgeGameState gameState = bridgeAnswer.compareWith(bridgePlayer);

        // then
        assertThat(gameState).isIn(SUCCESS, FAIL, CONTINUE);
    }

    static Stream<Arguments> whenCompareBridgeThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(UP, UP, UP)),
                Arguments.arguments(List.of(UP, DOWN, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, DOWN, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP, DOWN, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP, DOWN, UP, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP, DOWN, UP, UP, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP, DOWN, UP, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN, DOWN, UP, DOWN, UP, DOWN, UP, UP, UP, DOWN, DOWN))
        );
    }
}