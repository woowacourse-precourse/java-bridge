package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(3);
    }

    @Test
    void 움직임_테스트() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getPlayerCommand().get(0)).isEqualTo("U");
        assertThat(bridgeGame.getPlayerCommand().get(1)).isEqualTo("D");
    }

    @Test
    void 재시작_테스트() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry("R");
        assertThat(bridgeGame.getPlayerCommand().size()).isEqualTo(0);
    }

    @Test
    void 현재_상태_확인_테스트() {
        bridgeGame.move("U");
        bridgeGame.calculateStatus();
        assertThat(bridgeGame.getStatus()).isEqualTo("진행중");
    }

    @Test
    void 상태가_진행중일_때_참_테스트() {
        bridgeGame.setStatus("진행중");
        assertThat(bridgeGame.keepGoing()).isEqualTo(true);
    }

    @Test
    void 상태가_진행중이_아니면_거짓_테스트() {
        bridgeGame.setStatus("성공");
        assertThat(bridgeGame.keepGoing()).isEqualTo(false);
    }

}