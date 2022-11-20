package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("칸 움직이기 성공 테스트")
    @Test
    void successMovingTest() {
        List<String> blocks = List.of("U", "D");
        Bridge bridge = new Bridge(blocks);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(1);
        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(2);

    }

    @DisplayName("칸 움직이기 실패 테스트")
    @Test
    void failedMovingTest() {
        List<String> blocks = List.of("U", "D");
        Bridge bridge = new Bridge(blocks);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(0);

    }

}
