package bridge.domain.game;

import bridge.domain.bridge.BridgeSize;
import bridge.domain.game.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        BridgeSize bridgeSize = new BridgeSize(3);
        bridgeGame = new BridgeGame(bridgeSize);
    }

    @DisplayName("다리를 건넌다면 현재 위치가 1 증가한다.")
    @Test
    void increasePosition() {
        int curPosition = bridgeGame.getPosition();

        bridgeGame.move();

        assertThat(bridgeGame.getPosition()).isEqualTo(curPosition + 1);
    }
}