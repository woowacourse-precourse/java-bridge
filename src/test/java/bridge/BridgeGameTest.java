package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    @DisplayName("retry함수가 종료 명령이 들어왔을 때 false를 반환하는 지 테스트")
    @Test
    void retry() {
        final BridgeGame bridgeGame = new BridgeGame(3);
        String input = "Q";
        boolean result = bridgeGame.retry(input);
        assertThat(result)
                .isEqualTo(false);
    }
}
