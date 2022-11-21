package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("틀렸을 때 실패가 되어야 합니다.")
    @Test
    void moveTestIfFail() {
        List<String> answerBridge = List.of("U","D","U","D");
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        bridgeGame.move("D");

        assertThat(bridgeGame.getStatus()).isEqualTo(StatusType.FAIL);
    }
}
