package bridge;

import bridge.game.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame(3);

    @Test
    void bridgeGameTest() {
    }

    @DisplayName("[retry test] : Q 입력시, 종료 상태값인 2를 반환한다")
    @Test
    void retryTest() {
        int state = bridgeGame.retry("Q");
        Assertions.assertThat(2).isEqualTo(state);
    }

    @DisplayName("[retry test] : R 입력시, 계속 진행 상태값인 0을 반환 한다.")
    @Test
    void retryTest2() {
        int state = bridgeGame.retry("R");
        Assertions.assertThat(0).isEqualTo(state);
    }

    @DisplayName("[retry test] : R 입력시, 시도횟수인 try count가 1 증가한다")
    @Test
    void retryTest3() {
        int preTryCount = BridgeGame.tryCount;
        bridgeGame.retry("R");
        int postTryCount = BridgeGame.tryCount;

        Assertions.assertThat(preTryCount+1).isEqualTo(postTryCount);
    }
}
