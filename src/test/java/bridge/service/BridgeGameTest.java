package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BridgeGameTest {

    BridgeGame bridgeGame;
    List<String> movePath = Arrays.asList("U", "D", "D");

    @BeforeEach
    void init() {
        List<String> bridge = Arrays.asList("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    void 경로_정상입력() {
        movePathInput();

        assertThat(bridgeGame.getMovePath()).containsExactly(
                "U", "D", "D"
        );
    }

    @Test
    void 경로_와_다리경로_같음() {
        movePathInput();

        boolean isPossible = bridgeGame.checkPossibleMove(0);
        assertThat(isPossible).isTrue();
    }

    @Test
    void 경로_와_다리경로_다름() {
        movePathInput();

        boolean isPossible = bridgeGame.checkPossibleMove(2);
        assertThat(isPossible).isFalse();
    }

    @Test
    void 재시작_할때_이동경로_초기화() {
        movePathInput();

        bridgeGame.retry();
        assertThat(bridgeGame.getMovePath().size()).isEqualTo(0);
    }

    public void movePathInput() {
        for (int i = 0; i < movePath.size(); i++) {
            bridgeGame.move(movePath.get(i));
        }
    }
}