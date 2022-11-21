package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private List<String> bridge = List.of("U", "D");
    private BridgeGame bridgeGame;
    private BridgeState bridgeState;

    @BeforeEach
    void init() {
        bridgeState = new BridgeState();
        bridgeGame = new BridgeGame(bridge, bridgeState);
    }

    @DisplayName("게임 재시작 시 게임 총 도전 횟수 카운트 값 확인")
    @Test
    void confimTotalGameAttemptsWhenRetry() {
        bridgeGame.retry(RETRY);
        assertThat(bridgeGame.getTotalGameAttempts()).isEqualTo(BRIDGE_GAME_ATTEMPTS_INIT + 1);
    }

    @DisplayName("게임 재시작 시 위, 아래 다리 상태 초기화 확인")
    @Test
    void confirmInitBridgeStateWhenRetry() {
        bridgeGame.retry(RETRY);
        assertThat(bridgeState.getUpBridgeState().length()).isEqualTo(0);
        assertThat(bridgeState.getDownBridgeState().length()).isEqualTo(0);
    }

    @DisplayName("첫 라운드 다리 건너고 나서 위 다리 상태 값 확인")
    @ParameterizedTest
    @MethodSource("firstRoundUpBridgeState")
    void confirmFirstRoundUpBridgeState(String moving, String upBridgeState) {
        bridgeGame.move(moving);
        assertThat(bridgeState.getUpBridgeState()).isEqualTo(upBridgeState);
    }

    private static Stream<Arguments> firstRoundUpBridgeState() {
        return Stream.of(
            Arguments.of("U", " O "),
            Arguments.of("D", "   ")
        );
    }

    @DisplayName("첫 라운드 다리 건너고 나서 아래 다리 상태 값 확인")
    @ParameterizedTest
    @MethodSource("firstRoundDownBridgeState")
    void confirmFirstRoundDownBridgeState(String moving, String downBridgeState) {
        bridgeGame.move(moving);
        assertThat(bridgeState.getDownBridgeState()).isEqualTo(downBridgeState);
    }

    private static Stream<Arguments> firstRoundDownBridgeState() {
        return Stream.of(
                Arguments.of("U", "   "),
                Arguments.of("D", " X ")
        );
    }

    @DisplayName("두번째 라운드 다리 건너고 나서 위 다리 상태 값 확인")
    @ParameterizedTest
    @MethodSource("secondRoundUpBridgeState")
    void confirmSecondRoundUpBridgeState(String moving1, String moving2, String upBridgeState) {
        bridgeGame.move(moving1);
        bridgeGame.move(moving2);
        assertThat(bridgeState.getUpBridgeState()).isEqualTo(upBridgeState);
    }

    private static Stream<Arguments> secondRoundUpBridgeState() {
        return Stream.of(
                Arguments.of("U", "U", " O | X "),
                Arguments.of("U", "D", " O |   "),
                Arguments.of("D", "U", "   | X "),
                Arguments.of("D", "D", "   |   ")
        );
    }

    @DisplayName("두번째 라운드 다리 건너고 나서 아래 다리 상태 값 확인")
    @ParameterizedTest
    @MethodSource("secondRoundDownBridgeState")
    void confirmSecondRoundDownBridgeState(String moving1, String moving2, String downBridgeState) {
        bridgeGame.move(moving1);
        bridgeGame.move(moving2);
        assertThat(bridgeState.getDownBridgeState()).isEqualTo(downBridgeState);
    }

    private static Stream<Arguments> secondRoundDownBridgeState() {
        return Stream.of(
                Arguments.of("U", "U", "   |   "),
                Arguments.of("U", "D", "   | O "),
                Arguments.of("D", "U", " X |   "),
                Arguments.of("D", "D", " X | O ")
        );
    }
}