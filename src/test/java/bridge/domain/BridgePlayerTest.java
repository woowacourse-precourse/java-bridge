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
    @DisplayName("두 종류의 마지막 다리 이동 타입이 서로 같지 않은지 확인에 성공한다.")
    void whenCheckLastMoveTypeNotSameThenSuccessTest(List<BridgeMoveType> playerBridge, List<BridgeMoveType> compareBridge) {
        // given
        BridgePlayer bridgePlayer = new BridgePlayer();
        playerBridge.forEach(bridgePlayer::moveTo);

        // when
        boolean isLastMoveTypeNotSame = bridgePlayer.isLastMoveTypeNotSameAs(compareBridge);

        // then
        Assertions.assertThat(isLastMoveTypeNotSame).isTrue();
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
}