package bridge.domain.bridge.model;

import bridge.domain.bridge.BridgeDirection;
import bridge.domain.bridge.BridgeMap;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GamePlayer;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private GamePlayer gamePlayer;
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        List<String> bridge = Lists.newArrayList("U", "D", "D", "U");
        BridgeMap bridgeMap = BridgeMap.from(bridge);
        GamePlayer gamePlayer = GamePlayer.withDefaultValue();

        this.gamePlayer = gamePlayer;
        this.bridgeGame = BridgeGame.of(bridgeMap, gamePlayer);
    }

    @Test
    public void 다리_건너기_테스트_건넌_횟수_만큼_위치가_이동_되어_있다() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.UP);
        bridgeGame.move(BridgeDirection.DOWN);

        Assertions.assertThat(gamePlayer.getPosition()).isEqualTo(2);
    }

    @Test
    public void 다리_건너기_테스트_잘못된_방향으로_건넌_경우_실패() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.UP);
        bridgeGame.move(BridgeDirection.DOWN);
        bridgeGame.move(BridgeDirection.UP);

        Assertions.assertThat(gamePlayer.getPosition()).isEqualTo(3);
        Assertions.assertThat(gamePlayer.isFailGame()).isTrue();
    }

    @Test
    public void 게임_종료_조건_테스트_건너는_중_틀린_경우() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.UP);
        bridgeGame.move(BridgeDirection.DOWN);
        bridgeGame.move(BridgeDirection.UP);

        Assertions.assertThat(bridgeGame.isFailGame()).isTrue();
    }

    @Test
    public void 게임_종료_조건_테스트_모두_건넌_경우() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.UP);
        bridgeGame.move(BridgeDirection.DOWN);
        bridgeGame.move(BridgeDirection.DOWN);
        bridgeGame.move(BridgeDirection.UP);

        Assertions.assertThat(bridgeGame.isCrossedBridge()).isTrue();
    }


    @Test
    public void 재시작_테스트() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.UP);
        bridgeGame.move(BridgeDirection.DOWN);

        bridgeGame.retry();
        Assertions.assertThat(gamePlayer.getPosition()).isEqualTo(0);
        Assertions.assertThat(gamePlayer.getTrial()).isEqualTo(2);
        Assertions.assertThat(gamePlayer.isFailGame()).isFalse();
    }


}