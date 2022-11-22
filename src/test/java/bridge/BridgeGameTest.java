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

  @Test
  void 시작_혹은_재시작_시에_맵을_건널수_있는지_여부에_대해_올바른_boolean을_가지고_오는가() {

    // given
    Bridge bridge = new Bridge(3);
    BridgeGame bridgeGame = new BridgeGame(bridge);

    // then
    assertTrue(bridgeGame.canCross());
  }

  @Test
  void 시작_혹은_재시작_시에_게임_우승_여부가_false로_반환되는가() {

    // given
    Bridge bridge = new Bridge(3);
    BridgeGame bridgeGame = new BridgeGame(bridge);

    // then
    assertFalse(bridgeGame.isWin());
  }

  @Test
  void 재시작을_선택한경우_게임_시도_횟수가_증가하는가() {

    // given
    Bridge bridge = new Bridge(3);
    BridgeGame bridgeGame = new BridgeGame(bridge);

    // when
    bridgeGame.retry("R");

    // then
    assertTrue(bridgeGame.getResult().contains("총 시도한 횟수: 2"));
  }

  @Test
  void 올바른_게임_결과를_반환하는가() {

    // given
    Bridge bridge = new Bridge(3);
    BridgeGame bridgeGame = new BridgeGame(bridge);

    // then
    assertTrue(bridgeGame.getResult().contains("게임 성공 여부: 성공\n" + "총 시도한 횟수: 1"));
  }

}