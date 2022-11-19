package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 다리_이동_성공() {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));
        //when
        bridgeGame.move("U");
        //then
        assertThat(bridgeGame.isGameEnd()).isFalse();
    }

    @Test
    void 다리_이동_실패() {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));
        //when
        bridgeGame.move("D");
        //then
        assertThat(bridgeGame.isGameEnd()).isTrue();
    }

    @Test
    void 게임_재시작() {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));
        //when
        bridgeGame.retry("R");
        //then
        assertThat(bridgeGame.getGameCount()).isEqualTo(2);
        assertThat(bridgeGame.isGameEnd()).isFalse();
    }
}