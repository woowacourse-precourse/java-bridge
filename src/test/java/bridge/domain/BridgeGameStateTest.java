package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.domain.BridgeGameState.CONTINUE;
import static bridge.domain.BridgeGameState.START;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameStateTest {

    @ParameterizedTest(name = "[{index}] gameState = {0}")
    @MethodSource("whenCheckBridgeGameContinueThenSuccessDummy")
    @DisplayName("다리 게임이 계속 진행되는지 확인했을 때 진행 성공 테스트")
    void whenCheckBridgeGameContinueThenSuccessTest(BridgeGameState gameState) {
        // when
        boolean isBridgeGameContinue = gameState.isBridgeGameContinue();

        // then
        assertThat(isBridgeGameContinue).isTrue();
    }

    static Stream<Arguments> whenCheckBridgeGameContinueThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(START),
                Arguments.arguments(CONTINUE)
        );
    }
}