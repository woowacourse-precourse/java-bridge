package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();
    List bridge = List.of("U", "D", "U");

    @Test
    @DisplayName("다리 건너기 u or d 입력 후 값비교 후 결과 출력")
    void 다리건너기_입력후_값비교() {
        Assertions.assertThat(bridgeGame.move(bridge, 0, "U")).isEqualTo(true);
        Assertions.assertThat(bridgeGame.move(bridge, 1, "D")).isEqualTo(true);
        Assertions.assertThat(bridgeGame.move(bridge, 2, "D")).isEqualTo(false);
    }
}