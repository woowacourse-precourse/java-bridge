package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeGameTest {

    @DisplayName("플레이어 이동 테스트")
    @Test
    void createMovingTest() {
        List<String> bridge = List.of("U", "D", "D");
        String moving = "U";

        BridgeGame bridgeGame = new BridgeGame();
        MovingResult movingResult = bridgeGame.move(bridge, moving);

        assertThat(movingResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of("U", Result.SUCCESS));
    }
}