package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void initAll() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("bridge 와 동일한 position 으로 이동하면 true 를 반환한다.")
    @Test
    void moveTest1() {
        boolean result1 = bridgeGame.move("U");
        boolean result2 = bridgeGame.move("D");
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }

    @DisplayName("bridge 와 다른 position 으로 이동하면 false 를 반환한다.")
    @Test
    void moveTest2() {
        boolean result = bridgeGame.move("D");
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("move()를 통해 증가한 index 값이 retry()를 통해 0으로 초기화 된다.")
    @Test
    void retry() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getIndex()).isEqualTo(2);
        bridgeGame.retry();
        assertThat(bridgeGame.getIndex()).isEqualTo(0);
    }
}