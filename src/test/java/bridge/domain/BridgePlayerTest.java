package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.BridgeMoveType.DOWN;
import static bridge.domain.BridgeMoveType.UP;
import static bridge.exception.BridgePlayerExceptionMessage.BRIDGE_SIZE_SIZE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BridgePlayerTest {

    @ParameterizedTest(name = "[{index}] playerBridge = {0}, compareBridge = {1}")
    @MethodSource("whenCheckLastMoveTypeNotSameThenSuccessDummy")
    @DisplayName("플레이어를 다리에서 이동시키고 마지막 다리 이동 타입이 서로 동일하지 않은지 확인을 성공한다.")
    void whenCheckLastMoveTypeNotSameThenSuccessTest(List<BridgeMoveType> playerBridge, List<BridgeMoveType> compareBridge) {
        // given
        BridgePlayer bridgePlayer = new BridgePlayer();
        playerBridge.forEach(bridgePlayer::moveTo);

        // when
        boolean isLastMoveTypeNotSame = bridgePlayer.isLastMoveTypeNotSameAs(compareBridge);

        // then
        assertThat(isLastMoveTypeNotSame).isTrue();
    }

    @ParameterizedTest(name = "[{index}] playerBridge = {0}, compareBridge = {1}")
    @MethodSource("whenCheckMoveTypesAllSameThenSuccessDummy")
    @DisplayName("플레이어를 다리에서 이동시키고 다리 이동 정답과 모두 동일한지 확인을 성공한다.")
    void whenCheckMoveTypesAllSameThenSuccessTest(List<BridgeMoveType> playerBridge, List<BridgeMoveType> compareBridge) {
        // given
        BridgePlayer bridgePlayer = new BridgePlayer();
        playerBridge.forEach(bridgePlayer::moveTo);

        // when
        boolean isAllMoveTypesSame = bridgePlayer.isAllMoveTypeSameAs(compareBridge);

        // then
        assertThat(isAllMoveTypesSame).isTrue();
    }

    @ParameterizedTest(name = "[{index}] moveTypes = {0}")
    @MethodSource("moveTypesDummy")
    @DisplayName("플레이어의 다리 이동 기록 초기화에 성공한다.")
    void whenMovePlayerThenSuccessTest(List<BridgeMoveType> moveTypes) {
        // given
        BridgePlayer bridgePlayer = new BridgePlayer();

        // when
        moveTypes.forEach(bridgePlayer::moveTo);
        List<BridgeMoveType> playerMoveHistory = bridgePlayer.getMoveHistory();

        // then
        assertThat(playerMoveHistory).hasSize(moveTypes.size());
    }

    @ParameterizedTest(name = "[{index}] moveTypes = {0}")
    @MethodSource("moveTypesDummy")
    @DisplayName("플레이어를 다리 이동 타입을 이용하여 이동에 성공한다.")
    void whenClearPlayerMoveTypesThenSuccessTest(List<BridgeMoveType> moveTypes) {
        // given
        BridgePlayer bridgePlayer = new BridgePlayer();
        moveTypes.forEach(bridgePlayer::moveTo);

        // when
        bridgePlayer.clearPlayerBridge();
        List<BridgeMoveType> playerMoveHistory = bridgePlayer.getMoveHistory();

        // then
        assertThat(playerMoveHistory).isEmpty();
    }

    @ParameterizedTest(name = "[{index}] playerBridge = {0}, compareBridge = {1}")
    @MethodSource("whenBridgeSizeIsZeroThenExceptionDummy")
    @DisplayName("마지막 다리 이동 타입을 비교할 때 두 다리 중 하나라도 사이즈가 0이라면 실패하여 예외 처리된다.")
    void whenCheckLastMoveTypeSizeIsZeroThenExceptionTest(List<BridgeMoveType> playerBridge, List<BridgeMoveType> compareBridge) {
        // given & when
        BridgePlayer bridgePlayer = new BridgePlayer();
        playerBridge.forEach(bridgePlayer::moveTo);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bridgePlayer.isLastMoveTypeNotSameAs(compareBridge))
                .withMessage(BRIDGE_SIZE_SIZE_EXCEPTION.getMessage());
    }

    @ParameterizedTest(name = "[{index}] playerBridge = {0}, compareBridge = {1}")
    @MethodSource("whenBridgeSizeIsZeroThenExceptionDummy")
    @DisplayName("모든 다리 이동 타입을 비교할 때 두 다리 중 하나라도 사이즈가 0이라면 실패하여 예외 처리된다.")
    void whenCheckAllMoveTypesSizeIsZeroThenExceptionTest(List<BridgeMoveType> playerBridge, List<BridgeMoveType> compareBridge) {
        // given & when
        BridgePlayer bridgePlayer = new BridgePlayer();
        playerBridge.forEach(bridgePlayer::moveTo);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bridgePlayer.isAllMoveTypeSameAs(compareBridge))
                .withMessage(BRIDGE_SIZE_SIZE_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenCheckLastMoveTypeNotSameThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(UP, UP, UP, DOWN, DOWN), List.of(UP, UP, DOWN, DOWN, UP)),
                Arguments.arguments(List.of(DOWN, DOWN, UP, UP, DOWN), List.of(UP, UP, UP, DOWN, UP)),
                Arguments.arguments(List.of(UP, DOWN, UP, DOWN, DOWN), List.of(UP, UP, DOWN, DOWN, UP)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN), List.of(UP, DOWN, UP, DOWN, UP)),
                Arguments.arguments(List.of(UP, DOWN, UP, UP, DOWN), List.of(UP, DOWN, UP, DOWN, UP)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN), List.of(UP, UP, UP, DOWN, UP)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN), List.of(UP, DOWN, UP, DOWN, UP))
        );
    }

    static Stream<Arguments> whenCheckMoveTypesAllSameThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(UP, UP, UP, DOWN, DOWN), List.of(UP, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, DOWN, UP, UP, DOWN), List.of(DOWN, DOWN, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, DOWN, DOWN), List.of(UP, DOWN, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN), List.of(DOWN, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, UP, DOWN), List.of(UP, DOWN, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN), List.of(UP, UP, DOWN, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN), List.of(DOWN, UP, UP, DOWN, DOWN))
        );
    }

    static Stream<Arguments> moveTypesDummy() {
        return Stream.of(
                Arguments.arguments(List.of(UP, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, DOWN, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(UP, DOWN, UP, UP, DOWN)),
                Arguments.arguments(List.of(UP, UP, DOWN, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, UP, UP, DOWN, DOWN))
        );
    }

    static Stream<Arguments> whenBridgeSizeIsZeroThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(Collections.emptyList(), List.of(UP, UP, UP, DOWN, DOWN)),
                Arguments.arguments(List.of(DOWN, DOWN, UP, UP, DOWN), Collections.emptyList()),
                Arguments.arguments(Collections.emptyList(), List.of(UP, DOWN, UP)),
                Arguments.arguments(Collections.emptyList(), List.of(DOWN, UP, UP, DOWN, DOWN)),
                Arguments.arguments(Collections.emptyList(), List.of(UP)),
                Arguments.arguments(List.of(UP, UP,  DOWN, DOWN), Collections.emptyList()),
                Arguments.arguments(Collections.emptyList(), Collections.emptyList())
        );
    }
}