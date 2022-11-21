package bridge.domain;

import bridge.domain.BridgeGameHost;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @BeforeEach
    void beforeEach() {
        BridgeGameHost bridgeGameHost = new BridgeGameHost();
    }

    @Test
    @DisplayName("플레이어가 살아있는지 반환하는 기능")
    void isPlayerAlive() {
        // then
        assertThat(Player.getAlive()).isTrue();
    }

    @Test
    @DisplayName("플레이어의 Index 를 반환하는 기능")
    void getInitialPlayerIndex() {
        // then
        assertThat(Player.getIndex()).isEqualTo(-1);
    }

    @Test
    @DisplayName("플레이어의 총 시도 횟수를 반환하는 기능")
    void getRetry() {
        // then
        assertThat(Player.getNumberOfRetry()).isEqualTo(1);
    }
}
