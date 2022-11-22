package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("사용자가 입력한 값과 무작위로 저장된 다리의 값을 비교한다.")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThat(bridgeGame.move(0, "D")).isEqualTo(false);
    }

    @DisplayName(" 게임 재시작 여부를 입력한 값에 따라 비교한다.")
    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame(List.of());
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }
}