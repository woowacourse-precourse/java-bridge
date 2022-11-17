package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("BridgeGame 유저 이동 기능 테스트")
    @Test
    void Bridge_Game_이동_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame).extracting("userPosition").isEqualTo(1);

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame).extracting("userPosition").isEqualTo(2);

            bridgeGame.move(Direction.U);
            assertThat(bridgeGame).extracting("userPosition").isEqualTo(3);
        });
    }

    @DisplayName("유저가 잘못된 방향으로 진행하면 사망한다")
    @Test
    void 잘못된_이동_사망_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(Direction.D);
        assertThat(bridgeGame).extracting("aliveUser").isEqualTo(false);
    }


}