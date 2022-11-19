package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Const.*;
import static org.assertj.core.api.Assertions.as;
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
        assertThat(bridgeGameHost.getPlayerIndex()).isEqualTo(0);
        assertThat(bridgeGameHost.getPlayerAlive()).isTrue();
    }

    @Test
    @DisplayName("사용자가 움직여서 죽는 경우")
    void movePlayerAndPlayerDie() {
        // when
        bridgeGame.move(bridgeGameHost, DOWN);

        // then
        assertThat(bridgeGameHost.getPlayerIndex()).isEqualTo(0);
        assertThat(bridgeGameHost.getPlayerAlive()).isFalse();
    }

    @Test
    @DisplayName("재시작을 하는 경우")
    void playerRetry() {
        // given
        bridgeGameHost.movePlayer();
        bridgeGameHost.playerDie();

        // when
        bridgeGame.retry(bridgeGameHost);

        // then
        assertThat(bridgeGameHost.getPlayerIndex()).isEqualTo(-1);
        assertThat(bridgeGameHost.getPlayerAlive()).isTrue();
        assertThat(bridgeGameHost.getRetry()).isEqualTo(1);
    }

}
