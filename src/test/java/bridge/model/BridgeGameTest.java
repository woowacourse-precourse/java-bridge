package bridge.model;

import bridge.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 다리_이동_테스트1() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", Arrays.asList("U"));
        assertThat(bridgeGame.getUp()).isEqualTo(Arrays.asList(" O "));
    }

    @Test
    void 다리_이동_테스트2() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", Arrays.asList("D"));
        assertThat(bridgeGame.getUp()).isEqualTo(Arrays.asList(" X "));
    }

    @Test
    void 진행중_다리_횟수_테스트1() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", Arrays.asList("U","U"));
        assertThat(bridgeGame.getCurrentCount()).isEqualTo(1);
    }

    @Test
    void 진행중_다리_횟수_테스트2() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", Arrays.asList("U","U"));
        bridgeGame.move("D", Arrays.asList("U","U"));
        assertThat(bridgeGame.getCurrentCount()).isEqualTo(2);
    }
}