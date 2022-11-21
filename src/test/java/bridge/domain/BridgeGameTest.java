package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Const.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGame bridgeGame;
    private final List<String> testBridge = List.of("U", "D", "D", "U");

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
        Bridge.setBridge(testBridge);
        Player.set();
    }

    @Test
    @DisplayName("사용자를 움직여서 사는 경우")
    void movePlayerAndPlayerAlive() {
        // when
        bridgeGame.move(UP);

        // then
        assertThat(Player.getIndex()).isEqualTo(0);
        assertThat(Player.getAlive()).isTrue();
    }

    @Test
    @DisplayName("사용자가 움직여서 죽는 경우")
    void movePlayerAndPlayerDie() {
        // when
        bridgeGame.move(DOWN);

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
        bridgeGame.retry();

        // then
        assertThat(Player.getIndex()).isEqualTo(-1);
        assertThat(Player.getAlive()).isTrue();
        assertThat(Player.getNumberOfRetry()).isEqualTo(2);
    }
}
