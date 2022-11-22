package bridge;

import bridge.model.Bridge;
import bridge.service.BridgeGame;
import bridge.service.MapMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapMakerTest {

  @Test
  void 올바른_맵을_생성하고_이를_리턴하는가() {

    // given
    BridgeGame bridgeGame = new BridgeGame(new Bridge(3));
    MapMaker mapMaker = new MapMaker();

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