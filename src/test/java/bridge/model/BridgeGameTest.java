package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("이동 가능한 칸 검증 테스트")
    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame(3);
        List<List<String>> bridgeMap = new ArrayList<>();
        assertThat(bridgeGame.move("U", "U", bridgeMap)).isEqualTo(true);
        assertThat(bridgeGame.move("D", "U", bridgeMap)).isEqualTo(false);
    }

    @DisplayName("게임 재시도 검증 테스트")
    @Test
    void retryTest() {
        BridgeGame bridgeGame = new BridgeGame(3);
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }
}