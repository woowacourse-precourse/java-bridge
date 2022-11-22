package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        Player player = new Player(new ArrayList<>(), 1);
        bridgeGame = new BridgeGame(bridge, player);
    }

    @Test
    void 유저_이동_테스트() {
        String moving = "U";
        bridgeGame.move(moving);

        String lastMovedResult = bridgeGame.getPlayer().getLastMovedResult();
        assertThat(lastMovedResult).isEqualTo("O");
    }

    @Test
    void 재시작과_관련된_연산_수행_테스트() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry();

        int gameAttempts = bridgeGame.getPlayer().getGameAttempts();
        assertThat(gameAttempts).isEqualTo(2);

        String lastMovedResult = bridgeGame.getPlayer().getLastMovedResult();
        assertThat(lastMovedResult).isEqualTo("O");
    }

    @Test
    void 게임이_끝난_경우_테스트() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        boolean isEnd = bridgeGame.isEnd();
        assertThat(isEnd).isTrue();
    }

    @Test
    void 게임이_끝나지_않은_경우_테스트() {
        bridgeGame.move("U");

        boolean isEnd = bridgeGame.isEnd();
        assertThat(isEnd).isFalse();
    }

    @Test
    void 게임_시도_횟수_반환_테스트() {
        int gameAttempts;

        gameAttempts = bridgeGame.getGameAttempts();
        assertThat(gameAttempts).isEqualTo(1);

        bridgeGame.retry();

        gameAttempts = bridgeGame.getGameAttempts();
        assertThat(gameAttempts).isEqualTo(2);
    }

    @Test
    void 마지막_이동이_실패인지_판별하는_테스트_실패인_경우() {
        bridgeGame.move("D");

        boolean isLastMovedFailure = bridgeGame.isLastMovedFailure();
        assertThat(isLastMovedFailure).isTrue();
    }

    @Test
    void 마지막_이동이_실패인지_판별하는_테스트_성공인_경우() {
        bridgeGame.move("U");

        boolean isLastMovedFailure = bridgeGame.isLastMovedFailure();
        assertThat(isLastMovedFailure).isFalse();
    }
}