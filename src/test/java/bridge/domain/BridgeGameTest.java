package bridge.domain;

import bridge.vo.Commend;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("유저 게임 오버 테스트")
    void gameOverTest() {
        bridgeGame.setBridge(new Bridge(List.of(Commend.DOWN, Commend.DOWN, Commend.DOWN)));
        bridgeGame.move(Commend.DOWN);

        Assertions.assertThat(bridgeGame.gameOver()).isEqualTo(false);
    }

    @Test
    @DisplayName("유저 게임 오버 성공 테스트")
    void gameEndTest() {
        bridgeGame.setBridge(new Bridge(List.of(Commend.DOWN, Commend.DOWN, Commend.DOWN)));
        bridgeGame.move(Commend.DOWN);
        bridgeGame.move(Commend.DOWN);
        bridgeGame.move(Commend.DOWN);
        Assertions.assertThat(bridgeGame.gameOver()).isEqualTo(true);
    }

    @Test
    @DisplayName("유저 게임 재실행 확인 테스트")
    void gameCheckTest(){
        bridgeGame.setBridge(new Bridge(List.of(Commend.DOWN, Commend.DOWN, Commend.DOWN)));
        bridgeGame.move(Commend.DOWN);
        bridgeGame.move(Commend.UP);
        Assertions.assertThat(bridgeGame.roundClear()).isEqualTo(false);
    }
}