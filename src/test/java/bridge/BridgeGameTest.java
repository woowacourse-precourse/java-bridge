package bridge;

import bridge.model.Bridge;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

  @Test
  void 게임_플레이_시에_올바른_맵을_가지고_오는가() {

    // given
    Bridge bridge = new Bridge(3);
    BridgeGame bridgeGame = new BridgeGame(bridge);

    // when
    bridgeGame.play("U");

    // then
    if ((bridgeGame.getMap().equals("[ O ]\n[   ]"))) {
      assertEquals(bridgeGame.getMap(),"[ O ]\n[   ]");
    } else {
      assertEquals(bridgeGame.getMap(),"[   ]\n[ O ]");
    }

  }

}