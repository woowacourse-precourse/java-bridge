package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("틀렸을 때 FAIL이 되어야 합니다.")
    @Test
    void moveTestIfFail() {
        List<String> answerBridge = List.of("U","D","U","D");
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        bridgeGame.move("D");

        assertThat(bridgeGame.getStatus()).isEqualTo(StatusType.FAIL);
    }

    @DisplayName("재시도 시 route는 초기화되고, 상태는 PLAY로 변경되어야 합니다.")
    @Test
    void moveTestIfRetry() {
        List<String> answerBridge = List.of("U","D","U","D");
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        bridgeGame.move("D");
        bridgeGame.retry();

        assertThat(bridgeGame.getRoute()).isEmpty();
        assertThat(bridgeGame.getStatus()).isEqualTo(StatusType.PLAY);
    }

    @DisplayName("종료 시 상태는 FAIL로 변경되어야 합니다.")
    @Test
    void moveTestIfQuit() {
        List<String> answerBridge = List.of("U","D","U","D");
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        bridgeGame.quit();

        assertThat(bridgeGame.getStatus()).isEqualTo(StatusType.FAIL);
    }
}
