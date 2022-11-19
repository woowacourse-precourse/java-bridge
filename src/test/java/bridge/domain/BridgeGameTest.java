package bridge.domain;

import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        Bridge bridge = Bridge.valueOf(List.of("U", "D", "U"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리를 건넌다면 현재 위치가 1 증가한다.")
    @Test
    void increasePosition() {
        int curPosition = bridgeGame.getPosition();

        bridgeGame.move();

        assertThat(bridgeGame.getPosition()).isEqualTo(curPosition + 1);
    }
}