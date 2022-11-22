package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    private static final BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("이동 테스트")
    void move() {
        assertThat(bridgeGame.move(List.of("U", "U", "D"), List.of("U"))).isTrue();
        assertThat(bridgeGame.move(List.of("U", "U", "D"), List.of("D"))).isFalse();
        assertThat(bridgeGame.move(List.of("U", "U", "D"), List.of("U", "U", "D"))).isTrue();
        assertThat(bridgeGame.move(List.of("U", "U", "D"), List.of("U", "U", "U"))).isFalse();
        assertThat(bridgeGame.move(List.of("U", "U", "D", "D", "U"), List.of("U", "U", "D"))).isTrue();
        assertThat(bridgeGame.move(List.of("U", "U", "D", "D", "U"), List.of("U", "U", "U"))).isFalse();
        assertThat(bridgeGame.move(List.of("U", "U", "D", "D", "U"), List.of("U", "U", "D", "D", "U"))).isTrue();
        assertThat(bridgeGame.move(List.of("U", "U", "D", "D", "U"), List.of("U", "U", "D", "D", "D"))).isFalse();
    }

    @Test
    @DisplayName("재시작 테스트")
    void retry() {
        assertThat(bridgeGame.retry("R")).isTrue();
        assertThat(bridgeGame.retry("Q")).isFalse();
    }
}