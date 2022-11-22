package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.BridgeGameState.*;
import static bridge.domain.BridgeMoveType.DOWN;
import static bridge.domain.BridgeMoveType.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BridgeAnswerTest {

    @ParameterizedTest(name = "[{index}] bridgeSize = {0}")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @DisplayName("다리 길이를 이용한 다리 정답 생성을 확인  성공한다.")
    void whenSetUpBridgeAnswerBySizeThenSuccessTest(int bridgeSize) {
        // given
        BridgeAnswer bridgeAnswer = new BridgeAnswer();

        //  when
        bridgeAnswer.setUpAnswerSizeBy(bridgeSize);
        List<BridgeMoveType> moveHistory = bridgeAnswer.getAnswerMoveHistory();

        // then
        assertThat(moveHistory).hasSize(bridgeSize);
    }

    @ParameterizedTest(name = "[{index}] moveTypes = {0}")
    @MethodSource("moveTypeDummy")
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

    @ParameterizedTest(name = "[{index}] bridgeSize = {0}")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @DisplayName("두 다리의 마지막 위치가 같지만 길이가 다를 경우 CONTINUE 반환을 성공한다.")
    void whenSameMoveTypeAndDifferentLengthThenSuccessTest(int bridgeSize) {
        // given
        BridgeAnswer bridgeAnswer = new BridgeAnswer();
        bridgeAnswer.setUpAnswerSizeBy(bridgeSize);
        BridgePlayer bridgePlayer = new BridgePlayer();
        List<BridgeMoveType> moveTypes = bridgeAnswer.getAnswerMoveHistory().subList(0, bridgeSize - 1);
        moveTypes.forEach(bridgePlayer::moveTo);
        //  when
        BridgeGameState gameState = bridgeAnswer.compareWith(bridgePlayer);
        // then
        assertThat(gameState).isIn(CONTINUE);
    }

    @ParameterizedTest(name = "[{index}] bridgeSize = {0}")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @DisplayName("두 다리의 마지막 위치가 다를 경우 FAIL 반환을 성공한다.")
    void whenDifferentMoveTypeThenSuccessTest(int bridgeSize) {
        // given
        BridgeAnswer bridgeAnswer = new BridgeAnswer();
        bridgeAnswer.setUpAnswerSizeBy(bridgeSize);

        List<BridgeMoveType> moveTypes = bridgeAnswer.getAnswerMoveHistory();
        BridgeMoveType removedMoveType = moveTypes.remove(bridgeSize - 1);
        moveTypes.add(getReversedMoveType(removedMoveType));

        BridgePlayer bridgePlayer = new BridgePlayer();
        moveTypes.forEach(bridgePlayer::moveTo);
        //  when
        BridgeGameState gameState = bridgeAnswer.compareWith(bridgePlayer);
        // then
        assertThat(gameState).isIn(FAIL);
    }

    private BridgeMoveType getReversedMoveType(BridgeMoveType removedMoveType) {
        if (removedMoveType.isSame(UP)) {
            return DOWN;
        }
        return UP;
    }

    @ParameterizedTest(name = "[{index}] bridgeSize = {0}")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @DisplayName("두 다리의 길이와 모든 타입이 같을 경우 SUCCESS 반환을 성공한다.")
    void whenSameBridgeLengthAndMoveTypesThenSuccessTest(int bridgeSize) {
        // given
        BridgeAnswer bridgeAnswer = new BridgeAnswer();
        bridgeAnswer.setUpAnswerSizeBy(bridgeSize);
        List<BridgeMoveType> moveTypes = bridgeAnswer.getAnswerMoveHistory();
        BridgePlayer bridgePlayer = new BridgePlayer();
        moveTypes.forEach(bridgePlayer::moveTo);
        //  when
        BridgeGameState gameState = bridgeAnswer.compareWith(bridgePlayer);
        // then
        assertThat(gameState).isIn(SUCCESS);
    }

    @ParameterizedTest(name = "[{index}] moveTypes = {0}")
    @MethodSource("moveTypeDummy")
    @DisplayName("다리가 비어있을 경우에 비교 실패하여 예외 처리 된다.")
    void whenCompareEmptyBridgeThenExceptionTest(List<BridgeMoveType> moveTypes) {
        // given & when
        BridgeAnswer bridgeAnswer = new BridgeAnswer();
        BridgePlayer bridgePlayer = new BridgePlayer();
        moveTypes.forEach(bridgePlayer::moveTo);

        //  then
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> bridgeAnswer.compareWith(bridgePlayer));
    }

    static Stream<Arguments> moveTypeDummy() {
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