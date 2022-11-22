package bridge;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 게임_초기화_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        assertThat(bridgeGame.getRecord().isEmpty());
        assertThat(bridgeGame.getTrial() == 1);
        assertThat(bridgeGame.getSuccess().equals("실패"));
    }

    @Test
    void 사용자_움직임_테스트_틀림() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("D");
        assertThat(bridgeGame.getRecord()).containsExactly(2);
    }

    @Test
    void 사용자_움직임_테스트_맞힘_틀림() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.getRecord()).containsExactly(1, 3);
    }

    @Test
    void 사용자_움직임_테스트_맞힘_맞힘_틀림() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.getRecord()).containsExactly(1, 4, 3);
    }

    @Test
    void 사용자_움직임_테스트_맞힘_맞힘_맞힘() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getRecord()).containsExactly(1, 4, 4);
    }

    @Test
    void 게임_재시도_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertTrue(bridgeGame.retry("R"));
        assertThat(bridgeGame.getRecord()).isEmpty();
        assertThat(bridgeGame.getTrial()).isEqualTo(2);
    }

    @Test
    void 다리를_모두_건넌_경우_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertTrue(bridgeGame.checkComplete());
        assertThat(bridgeGame.getSuccess()).isEqualTo("성공");
    }

    @Test
    void 다리_건너기를_실패한_경우_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initialize(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertTrue(bridgeGame.hasFail());
    }

}