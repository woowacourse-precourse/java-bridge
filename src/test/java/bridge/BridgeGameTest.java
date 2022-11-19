package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("다음 위치가 이동할 수 있는 다리 칸인지 확인 ")
    @Test
    void move() {
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String direct = "U";
        assertThat(bridgeGame.move(direct)).isTrue();
    }
}