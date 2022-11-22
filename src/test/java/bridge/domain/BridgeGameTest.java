package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Const.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGame bridgeGame;
    private Player player;
    private Bridge bridge;
    private final List<String> testBridge = List.of("U", "D", "D", "U");

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
        player = new Player();
        bridge = new Bridge(testBridge);
    }

    @Test
    @DisplayName("사용자를 움직여서 사는 경우")
    void movePlayerAndPlayerAlive() {
        // when
        bridgeGame.move(player, bridge, UP);

        // then
        assertThat(player.getIndex()).isEqualTo(0);
        assertThat(player.getAlive()).isTrue();
    }

    @Test
    @DisplayName("사용자가 움직여서 죽는 경우")
    void movePlayerAndPlayerDie() {
        // when
        bridgeGame.move(player, bridge, DOWN);

        // then
        assertThat(player.getIndex()).isEqualTo(0);
        assertThat(player.getAlive()).isFalse();
    }

    @Test
    @DisplayName("재시작을 하는 경우")
    void playerRetry() {
        // given
        player.moving();
        player.dead();

        // when
        bridgeGame.retry(player);

        // then
        assertThat(player.getIndex()).isEqualTo(-1);
        assertThat(player.getAlive()).isTrue();
        assertThat(player.getNumberOfRetry()).isEqualTo(2);
    }
}
