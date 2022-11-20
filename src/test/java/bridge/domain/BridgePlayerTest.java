package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.BridgeMoveType.*;

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
        Assertions.assertThat(isLastMoveTypeNotSame).isTrue();
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
        Assertions.assertThat(isAllMoveTypesSame).isTrue();
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
}