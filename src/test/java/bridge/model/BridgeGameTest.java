package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @DisplayName("첫 시도에 끝까지 성공하면 시도 횟수는 1, 상태는 성공이다.")
    @Test
    void successInFirstAttempt() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isTrue();
        assertThat(bridgeGame.getCountOfAttempts()).isEqualTo(1);
    }

    @DisplayName("두번째 시도에 끝까지 성공하면 시도 횟수는 2, 상태는 성공이다.")
    @Test
    void successInSecondAttempt() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isFalse();
        assertThat(bridgeGame.isNeedsRetry()).isTrue();
        assertThat(bridgeGame.getCountOfAttempts()).isEqualTo(1);
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isTrue();
        assertThat(bridgeGame.getCountOfAttempts()).isEqualTo(2);
    }

    @DisplayName("첫번째 시도에 끝까지 실패하면 시도 횟수는 1, 상태는 실패다.")
    @Test
    void failInFirstAttempt() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isFalse();
        assertThat(bridgeGame.isNeedsRetry()).isTrue();
        assertThat(bridgeGame.getCountOfAttempts()).isEqualTo(1);
    }
}
