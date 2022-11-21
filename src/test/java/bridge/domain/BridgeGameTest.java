package bridge.domain;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameHost;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Const.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGameHost bridgeGameHost;
    private BridgeGame bridgeGame;
    private final List<String> testBridge = List.of("U", "D", "D", "U");

    @BeforeEach
    void beforeEach() {
        bridgeGameHost = new BridgeGameHost();
        bridgeGame = new BridgeGame();
        bridgeGameHost.setBridge(testBridge);
    }

    @Test
    @DisplayName("사용자를 움직여서 사는 경우")
    void movePlayerAndPlayerAlive() {
        // when
        bridgeGame.move(bridgeGameHost, UP);

        // then
        assertThat(Player.getIndex()).isEqualTo(0);
        assertThat(Player.getAlive()).isTrue();
    }

    @Test
    @DisplayName("사용자가 움직여서 죽는 경우")
    void movePlayerAndPlayerDie() {
        // when
        bridgeGame.move(bridgeGameHost, DOWN);

        // then
        assertThat(Player.getIndex()).isEqualTo(0);
        assertThat(Player.getAlive()).isFalse();
    }

    @Test
    @DisplayName("재시작을 하는 경우")
    void playerRetry() {
        // given
        Player.moving();
        Player.dead();

        // when
        bridgeGame.retry(bridgeGameHost);

        // then
        assertThat(Player.getIndex()).isEqualTo(-1);
        assertThat(Player.getAlive()).isTrue();
        assertThat(Player.getNumberOfRetry()).isEqualTo(2);
    }
}
