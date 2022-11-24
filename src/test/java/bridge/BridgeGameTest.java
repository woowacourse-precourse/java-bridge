package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 이동_테스트_이동가능() {
        boolean answer = true;
        Assertions.assertThat(bridgeGame.move("U", "U")).isEqualTo(answer);
    }

    @Test
    void 이동_테스트_이동불가() {
        boolean answer = false;
        Assertions.assertThat(bridgeGame.move("U", "D")).isEqualTo(answer);
    }

    @Test
    void 재시작_테스트_재시작() {
        boolean answer = true;
        Assertions.assertThat(bridgeGame.move("R", "R")).isEqualTo(answer);
    }

    @Test
    void 재시작_테스트_종료() {
        boolean answer = false;
        Assertions.assertThat(bridgeGame.move("R", "Q")).isEqualTo(answer);
    }
}
