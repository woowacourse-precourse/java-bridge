package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

  BridgeGame bridgeGame;
  Bridge bridge;
  GameState gameState;

  @BeforeEach
  void setUp(){
    bridge = new Bridge(List.of("U","U","D"));
    gameState = new GameState();
    bridgeGame = new BridgeGame(bridge, gameState);
  }

  @Test
  void 이동시_성공하면_유저의기록에_성공이추가된다(){
    BridgeArea givenNextArea = BridgeArea.U;

    boolean moveResult = bridgeGame.move(givenNextArea);

    assertThat(moveResult).isTrue();
    assertThat(gameState.getMovementHistory().size()).isEqualTo(1);
    assertThat(gameState.getMovementHistory().get(0)).isEqualTo(givenNextArea);
    assertThat(gameState.getStateHistory().get(0)).isTrue();
  }

  @Test
  void 이동에_실패하면_유저의기록에_실패가추가된다(){
    BridgeArea givenNextArea = BridgeArea.D;

    boolean result = bridgeGame.move(givenNextArea);

    assertThat(result).isFalse();
    assertThat(gameState.getMovementHistory().size()).isEqualTo(1);
    assertThat(gameState.getStateHistory().size()).isEqualTo(1);
    assertThat(gameState.getStateHistory().get(0)).isFalse();
  }

  @Test
  void 게임을모두수행하면_isClear가True를_반환한다(){
    bridgeGame.move(BridgeArea.U);
    bridgeGame.move(BridgeArea.U);
    bridgeGame.move(BridgeArea.D);

    boolean clearResult = bridgeGame.isClear();
    assertThat(clearResult).isTrue();
  }

  @Test
  void 게임을모두수행하지않으면_isClear가False를_반환한다(){
    bridgeGame.move(BridgeArea.U);
    bridgeGame.move(BridgeArea.U);

    boolean clearResult = bridgeGame.isClear();
    assertThat(clearResult).isFalse();
  }

  @Test
  void 게임재시작시_게임카운트가증가하고_유저기록이리셋된다(){
    int currentCount = gameState.getTryCount();
    bridgeGame.move(BridgeArea.U);

    bridgeGame.retry();

    assertThat(gameState.getTryCount()).isEqualTo(currentCount+1);
    assertThat(gameState.getMovementHistory().size()).isEqualTo(0);
  }
}