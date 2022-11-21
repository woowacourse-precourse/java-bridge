package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    @Test
    void testRetry() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        boolean isRetry = bridgeGame.retry("R");
        assertThat(isRetry).isEqualTo(true);
        assertThat(bridgeGame.getTrial()).isEqualTo(2);
    }

    @Test
    void testQuit() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        boolean isRetry = bridgeGame.retry("Q");
        assertThat(isRetry).isEqualTo(false);
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
    }

    @Test
    void testValidate() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        assertThatThrownBy(() -> bridgeGame.retry("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testErrorMessage() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        try {
            bridgeGame.retry("q");
            throw new RuntimeException();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("[ERROR] R(재시작) 또는 Q(종료)만 입력할 수 있습니다.");
        }

    }
}