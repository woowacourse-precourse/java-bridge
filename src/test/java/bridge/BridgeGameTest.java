package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("사용자의 움직임에 따른 결과를 boolean 으로 리턴함")
    @Test
    void moveReturnValueTest() {
        // Given
        BridgeGame bridgeGame = create(List.of("U", "U", "D", "D", "U"));

        // When & Then
        assertThat(bridgeGame.move("D")).isFalse();
        assertThat(bridgeGame.move("U")).isTrue();
    }

    @DisplayName("사용자가 알맞은 다리를 건너면 유저의 현재단계가 증가함")
    @Test
    void userCurrentStepTest() {
        // Given
        BridgeGame bridgeGame = create(List.of("U", "U", "D", "D", "U"));

        // When
        bridgeGame.move("U");
        bridgeGame.move("U");

        // Then
        assertThat(bridgeGame.getUserSteps().size()).isEqualTo(2);
    }

    @DisplayName("사용자가 재시도를 수행하면 시도횟수가 증가하고 현재단계가 초기화됨")
    @Test
    void retryTest() {
        // Given
        BridgeGame bridgeGame = create(List.of("U", "U", "D", "D", "U"));

        // When
        bridgeGame.retry();

        // Then
        assertThat(bridgeGame.getTrial()).isEqualTo(2);
        assertThat(bridgeGame.getUserSteps().size()).isEqualTo(0);
    }

    private BridgeGame create(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.buildBridge(bridge);
        return bridgeGame;
    }

}