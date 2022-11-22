package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void beforeEach() {
        Player player = new Player();
        List<String> bridge = Arrays.asList("U", "D", "D");
        bridgeGame.initBridgeGame(player, bridge);
    }

    @DisplayName("올바른 방향으로 가면 'NEXT'가 리턴되는지 확인")
    @Test
    void move_올바른_방향_이동() {
        assertThat(bridgeGame.move("U")).isEqualTo("NEXT");
    }

    @DisplayName("잘못된 방향으로 가면 'FAIL'이 리턴되는지 확인")
    @Test
    void move_잘못된_방향_이동() {
        assertThat(bridgeGame.move("D")).isEqualTo("FAIL");
    }

    @Test
    void retry() {
    }
}